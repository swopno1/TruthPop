package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.PromptRepository
import com.example.data.UserPreferencesRepository
import com.example.model.GameCategory
import com.example.model.Intensity
import com.example.model.Language
import com.example.model.PromptItem
import com.example.model.PromptType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

data class TruthPopUiState(
    val selectedType: PromptType? = PromptType.TRUTH, // null means Surprise/Random
    val selectedCategory: GameCategory = GameCategory.FRIENDS,
    val selectedIntensity: Intensity = Intensity.FUN,
    val currentLanguage: Language = Language.ENGLISH,
    val currentPrompt: PromptItem = PromptRepository.prompts.first(),
    val isHapticsEnabled: Boolean = true,
    val players: List<String> = emptyList(),
    val currentTurnPlayer: String? = null,
    val isCardRevealed: Boolean = true,
    val favorites: Set<String> = emptySet(),
    val showAboutDialog: Boolean = false,
    val showPlayerPicker: Boolean = false,
    val completedCount: Int = 0
)

class TruthPopViewModel(application: Application) : AndroidViewModel(application) {

    private val prefsRepository = UserPreferencesRepository(application.applicationContext)

    private val _uiState = MutableStateFlow(TruthPopUiState())
    val uiState: StateFlow<TruthPopUiState> = _uiState.asStateFlow()

    private val recentPromptIds = mutableListOf<String>()

    init {
        rollNextPrompt(forceReveal = true)
        // Overlay persisted preferences (language, haptics, favorites) once loaded.
        viewModelScope.launch {
            try {
                val prefs = prefsRepository.prefs.first()
                _uiState.update { state ->
                    state.copy(
                        currentLanguage = prefs.languageCode?.let { code ->
                            Language.entries.firstOrNull { it.code == code }
                        } ?: state.currentLanguage,
                        isHapticsEnabled = prefs.haptics ?: state.isHapticsEnabled,
                        favorites = prefs.favorites ?: state.favorites
                    )
                }
            } catch (_: Exception) {
                // Corrupt or missing prefs: keep defaults.
            }
        }
    }

    fun selectType(type: PromptType?) {
        _uiState.update { it.copy(selectedType = type) }
        rollNextPrompt()
    }

    fun selectCategory(category: GameCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
        rollNextPrompt()
    }

    fun selectIntensity(intensity: Intensity) {
        _uiState.update { it.copy(selectedIntensity = intensity) }
        rollNextPrompt()
    }

    fun toggleLanguage() {
        _uiState.update {
            val newLang = if (it.currentLanguage == Language.ENGLISH) Language.BANGLA else Language.ENGLISH
            viewModelScope.launch {
                try {
                    prefsRepository.setLanguage(newLang.code)
                } catch (_: Exception) {
                    // Persistence is best-effort; in-memory state already updated.
                }
            }
            it.copy(currentLanguage = newLang)
        }
    }

    fun toggleHaptics() {
        _uiState.update {
            viewModelScope.launch {
                try {
                    prefsRepository.setHaptics(!it.isHapticsEnabled)
                } catch (_: Exception) {
                }
            }
            it.copy(isHapticsEnabled = !it.isHapticsEnabled)
        }
    }

    fun toggleFavorite(promptId: String) {
        _uiState.update { state ->
            val updated = if (state.favorites.contains(promptId)) {
                state.favorites - promptId
            } else {
                state.favorites + promptId
            }
            viewModelScope.launch {
                try {
                    prefsRepository.setFavorites(updated)
                } catch (_: Exception) {
                }
            }
            state.copy(favorites = updated)
        }
    }

    fun setAboutDialogVisible(visible: Boolean) {
        _uiState.update { it.copy(showAboutDialog = visible) }
    }

    fun setPlayerPickerVisible(visible: Boolean) {
        _uiState.update { it.copy(showPlayerPicker = visible) }
    }

    fun addPlayer(name: String) {
        val trimmed = name.trim()
        if (trimmed.isEmpty()) return
        _uiState.update { state ->
            if (!state.players.contains(trimmed)) {
                val updated = state.players + trimmed
                state.copy(players = updated)
            } else {
                state
            }
        }
    }

    fun removePlayer(name: String) {
        _uiState.update { state ->
            val updated = state.players - name
            val nextTurn = if (state.currentTurnPlayer == name) null else state.currentTurnPlayer
            state.copy(players = updated, currentTurnPlayer = nextTurn)
        }
    }

    fun spinNextPlayer() {
        val currentPlayers = _uiState.value.players
        if (currentPlayers.isEmpty()) return
        val randomIndex = Random.nextInt(currentPlayers.size)
        val picked = currentPlayers[randomIndex]
        _uiState.update { it.copy(currentTurnPlayer = picked) }
        rollNextPrompt()
    }

    fun rollNextPrompt(forceReveal: Boolean = false) {
        val state = _uiState.value
        val pool = PromptRepository.filterPrompts(
            type = state.selectedType,
            category = state.selectedCategory,
            intensity = state.selectedIntensity
        )

        // Try to pick one not in recent history
        val candidates = pool.filter { !recentPromptIds.contains(it.id) }.ifEmpty { pool }
        val nextPrompt = candidates.randomOrNull() ?: PromptRepository.prompts.first()

        recentPromptIds.add(nextPrompt.id)
        if (recentPromptIds.size > 15) {
            recentPromptIds.removeAt(0)
        }

        _uiState.update {
            it.copy(
                currentPrompt = nextPrompt,
                isCardRevealed = forceReveal || it.isCardRevealed,
                completedCount = it.completedCount + 1
            )
        }
    }

    fun skipPrompt() {
        rollNextPrompt()
    }
}
