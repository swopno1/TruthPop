package com.example.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.ads.InterstitialAdManager
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material.icons.outlined.Vibration
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ads.AdBannerView
import com.example.model.GameCategory
import com.example.model.Intensity
import com.example.model.Language
import com.example.model.PromptItem
import com.example.model.PromptType
import com.example.ui.components.AboutDialog
import com.example.ui.components.PlayerPickerDialog
import com.example.ui.theme.DareColor
import com.example.ui.theme.DareContainer
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NeonPink
import com.example.ui.theme.NeonPurple
import com.example.ui.theme.TruthColor
import com.example.ui.theme.TruthContainer
import com.example.util.HapticHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TruthPopApp(
    viewModel: TruthPopViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(NeonPurple),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "🎈", fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "TruthPop",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = if (uiState.currentLanguage == Language.BANGLA) "পার্টি গেম" else "Party Edition",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                actions = {
                    // Language switch chip
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .clickable {
                                HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                                viewModel.toggleLanguage()
                            }
                            .testTag("language_switch_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Translate,
                                contentDescription = "Change Language",
                                modifier = Modifier.size(16.dp),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (uiState.currentLanguage == Language.ENGLISH) "EN" else "বাং",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    // Haptic feedback toggle
                    IconButton(
                        onClick = { viewModel.toggleHaptics() },
                        modifier = Modifier.testTag("haptic_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (uiState.isHapticsEnabled) Icons.Filled.Vibration else Icons.Outlined.Vibration,
                            contentDescription = "Haptic feedback toggle",
                            tint = if (uiState.isHapticsEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Party Players Sheet
                    IconButton(
                        onClick = { viewModel.setPlayerPickerVisible(true) },
                        modifier = Modifier.testTag("player_picker_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Group,
                            contentDescription = "Players",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    // Info / About Dialog
                    IconButton(
                        onClick = { viewModel.setAboutDialogVisible(true) },
                        modifier = Modifier.testTag("about_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About TruthPop"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            // Clean AdMob Test Banner
            AdBannerView()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(6.dp))

            // Active player turn banner (if available)
            if (uiState.currentTurnPlayer != null) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.setPlayerPickerVisible(true) }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "👑", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (uiState.currentLanguage == Language.BANGLA)
                                    "${uiState.currentTurnPlayer}-এর পালা!"
                                else
                                    "👉 ${uiState.currentTurnPlayer}'s Turn!",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                        Text(
                            text = if (uiState.currentLanguage == Language.BANGLA) "বদলাও" else "Change",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Mode Selector (TRUTH / DARE / SURPRISE)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("type_selector_row"),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Truth Button
                TypeSelectButton(
                    label = if (uiState.currentLanguage == Language.BANGLA) "সত্য" else "TRUTH",
                    emoji = "🎯",
                    isSelected = (uiState.selectedType == PromptType.TRUTH),
                    activeColor = TruthColor,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                        viewModel.selectType(PromptType.TRUTH)
                    }
                )

                // Dare Button
                TypeSelectButton(
                    label = if (uiState.currentLanguage == Language.BANGLA) "সাহস" else "DARE",
                    emoji = "🔥",
                    isSelected = (uiState.selectedType == PromptType.DARE),
                    activeColor = DareColor,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                        viewModel.selectType(PromptType.DARE)
                    }
                )

                // Surprise / Random Button
                TypeSelectButton(
                    label = if (uiState.currentLanguage == Language.BANGLA) "লটারি" else "RANDOM",
                    emoji = "🎲",
                    isSelected = (uiState.selectedType == null),
                    activeColor = NeonPink,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                        viewModel.selectType(null)
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Category Chips Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("category_selector_row"),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                GameCategory.values().forEach { category ->
                    val isSelected = (uiState.selectedCategory == category)
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                            viewModel.selectCategory(category)
                        },
                        label = {
                            Text(
                                text = "${category.iconEmoji} " + if (uiState.currentLanguage == Language.BANGLA) category.labelBn else category.labelEn,
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Intensity Selector
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("intensity_selector_row"),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Intensity.values().forEach { intensity ->
                    val isSelected = (uiState.selectedIntensity == intensity)
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                            viewModel.selectIntensity(intensity)
                        },
                        label = {
                            Text(
                                text = "${intensity.emoji} " + if (uiState.currentLanguage == Language.BANGLA) intensity.labelBn else intensity.labelEn,
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Animated Interactive Prompt Card
            AnimatedContent(
                targetState = uiState.currentPrompt,
                transitionSpec = {
                    fadeIn(animationSpec = tween(220)) togetherWith fadeOut(animationSpec = tween(220))
                },
                label = "prompt_card_animation"
            ) { prompt ->
                PromptPopCard(
                    prompt = prompt,
                    language = uiState.currentLanguage,
                    isFavorite = uiState.favorites.contains(prompt.id),
                    onToggleFavorite = { viewModel.toggleFavorite(prompt.id) },
                    onSharePrompt = { sharePrompt(context, prompt, uiState.currentLanguage) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Action Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Skip Button (pressure-free consent)
                OutlinedButton(
                    onClick = {
                        HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                        viewModel.skipPrompt()
                        InterstitialAdManager.onUserAction(context as? Activity)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .testTag("skip_button"),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(imageVector = Icons.Default.SkipNext, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (uiState.currentLanguage == Language.BANGLA) "স্কিপ" else "Skip",
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Next Prompt / Pop Button
                Button(
                    onClick = {
                        HapticHelper.popVibrate(context, uiState.isHapticsEnabled)
                        viewModel.rollNextPrompt()
                        InterstitialAdManager.onUserAction(context as? Activity)
                    },
                    modifier = Modifier
                        .weight(2f)
                        .height(52.dp)
                        .testTag("next_prompt_button"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NeonPurple
                    )
                ) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (uiState.currentLanguage == Language.BANGLA) "নতুন প্রম্পট! 💥" else "POP NEXT! 💥",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    // Dialogs
    if (uiState.showAboutDialog) {
        AboutDialog(onDismiss = { viewModel.setAboutDialogVisible(false) })
    }

    if (uiState.showPlayerPicker) {
        PlayerPickerDialog(
            players = uiState.players,
            currentTurnPlayer = uiState.currentTurnPlayer,
            onAddPlayer = { viewModel.addPlayer(it) },
            onRemovePlayer = { viewModel.removePlayer(it) },
            onSpinPlayer = { viewModel.spinNextPlayer() },
            onDismiss = { viewModel.setPlayerPickerVisible(false) }
        )
    }
}

@Composable
private fun TypeSelectButton(
    label: String,
    emoji: String,
    isSelected: Boolean,
    activeColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) activeColor else MaterialTheme.colorScheme.surfaceVariant,
        border = if (isSelected) null else BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier
            .height(48.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = emoji, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun PromptPopCard(
    prompt: PromptItem,
    language: Language,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onSharePrompt: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isTruth = (prompt.type == PromptType.TRUTH)
    val accentColor = if (isTruth) Color(0xFF0284C7) else Color(0xFFEA580C)
    // High-contrast fresh background
    val cardBgColor = if (isTruth) Color(0xFFF0F9FF) else Color(0xFFFFF7ED)

    Card(
        modifier = modifier.testTag("prompt_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardBgColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(2.5.dp, accentColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Type Badge
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = accentColor
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isTruth) "🎯 TRUTH" else "🔥 DARE",
                            style = MaterialTheme.typography.labelMedium,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }
                }

                // Category & Intensity (Dark high-contrast text)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${prompt.category.iconEmoji} ${prompt.category.labelEn}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF334155),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "• ${prompt.intensity.emoji} ${prompt.intensity.labelEn}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF334155),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    // Favorite Button
                    IconButton(
                        onClick = onToggleFavorite,
                        modifier = Modifier.size(36.dp).testTag("favorite_button")
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) NeonPink else Color(0xFF64748B)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Main Prompt Text (High Contrast Dark Slate)
            val primaryText = if (language == Language.BANGLA) prompt.textBn else prompt.textEn
            val secondaryText = if (language == Language.BANGLA) prompt.textEn else prompt.textBn

            Text(
                text = primaryText,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 24.sp,
                    lineHeight = 34.sp
                ),
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0F172A), // Deep Navy Charcoal for maximum contrast on light bg
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth().testTag("prompt_text")
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Dual language subtitle hint (Clean white container with dark text)
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color.White,
                border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = if (language == Language.BANGLA) "English translation:" else "বাংলা অনুবাদ:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = secondaryText,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 17.sp,
                            lineHeight = 24.sp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1E293B) // High contrast dark charcoal
                    )
                }
            }

            // Hint / Tip (Bright warm container with dark amber text)
            val hint = if (language == Language.BANGLA) prompt.hintBn else prompt.hintEn
            if (hint != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFFEF3C7),
                    border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "💡", fontSize = 15.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF78350F) // Deep Amber Brown for optimal contrast
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Share button row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isTruth) Color(0xFFE0F2FE) else Color(0xFFFFEDD5),
                    modifier = Modifier
                        .clickable { onSharePrompt() }
                        .testTag("share_prompt_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share prompt",
                            tint = accentColor,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (language == Language.BANGLA) "শেয়ার করো" else "Share Prompt",
                            color = accentColor,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

private fun sharePrompt(context: Context, prompt: PromptItem, language: Language) {
    val text = if (language == Language.BANGLA) prompt.textBn else prompt.textEn
    val typeLabel = if (prompt.type == PromptType.TRUTH) "🎯 TRUTH" else "🔥 DARE"
    val shareContent = """
        🎈 TruthPop Challenge!
        $typeLabel [${prompt.category.labelEn} - ${prompt.intensity.labelEn}]
        
        "$text"
        
        Can you answer or dare to do it?
        Play TruthPop – Truth or Dare!
    """.trimIndent()

    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareContent)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share TruthPop Prompt via")
    context.startActivity(shareIntent)
}
