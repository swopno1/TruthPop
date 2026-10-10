package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.PromptRepository
import com.example.model.GameCategory
import com.example.model.Intensity
import com.example.model.Language
import com.example.model.PromptType
import com.example.ui.TruthPopViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class TruthPopRobolectricTest {

    @Test
    fun testAppNameResource() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("TruthPop", appName)
    }

    @Test
    fun testPromptRepositoryCompleteness() {
        val allPrompts = PromptRepository.prompts
        assertTrue("Prompt repository should not be empty", allPrompts.isNotEmpty())

        allPrompts.forEach { prompt ->
            assertTrue("English text must not be blank", prompt.textEn.isNotBlank())
            assertTrue("Bangla text must not be blank", prompt.textBn.isNotBlank())
            assertNotNull(prompt.category)
            assertNotNull(prompt.intensity)
            assertNotNull(prompt.type)
        }
    }

    @Test
    fun testPromptFiltering() {
        val friendsChill = PromptRepository.filterPrompts(
            type = PromptType.TRUTH,
            category = GameCategory.FRIENDS,
            intensity = Intensity.CHILL
        )
        assertTrue(friendsChill.isNotEmpty())
        friendsChill.forEach {
            assertEquals(PromptType.TRUTH, it.type)
            assertEquals(GameCategory.FRIENDS, it.category)
            assertEquals(Intensity.CHILL, it.intensity)
        }
    }

    @Test
    fun testViewModelStateFlow() {
        val vm = TruthPopViewModel()
        val initial = vm.uiState.value

        assertEquals(Language.ENGLISH, initial.currentLanguage)
        assertNotNull(initial.currentPrompt)

        // Toggle language
        vm.toggleLanguage()
        assertEquals(Language.BANGLA, vm.uiState.value.currentLanguage)

        // Add player and spin
        vm.addPlayer("Alex")
        vm.addPlayer("Priya")
        assertEquals(2, vm.uiState.value.players.size)

        vm.spinNextPlayer()
        assertNotNull(vm.uiState.value.currentTurnPlayer)
        assertTrue(vm.uiState.value.players.contains(vm.uiState.value.currentTurnPlayer))

        // Change category and intensity
        vm.selectCategory(GameCategory.COUPLES)
        assertEquals(GameCategory.COUPLES, vm.uiState.value.selectedCategory)

        vm.selectIntensity(Intensity.SPICY)
        assertEquals(Intensity.SPICY, vm.uiState.value.selectedIntensity)

        // Favorite toggle
        val promptId = vm.uiState.value.currentPrompt.id
        vm.toggleFavorite(promptId)
        assertTrue(vm.uiState.value.favorites.contains(promptId))

        vm.toggleFavorite(promptId)
        assertFalse(vm.uiState.value.favorites.contains(promptId))

        // Skip prompt test
        val prevCompletedCount = vm.uiState.value.completedCount
        vm.skipPrompt()
        assertTrue(vm.uiState.value.completedCount > prevCompletedCount)

        // Surprise / Random mode (type = null)
        vm.selectType(null)
        assertNotNull(vm.uiState.value.currentPrompt)
    }

    @Test
    fun testAdConfigIdentifiers() {
        assertEquals("ca-app-pub-5222053984568989~4125909776", com.example.ads.AdConfig.APP_ID)
        assertEquals("ca-app-pub-5222053984568989/1274631134", com.example.ads.AdConfig.BANNER_AD_UNIT_ID)
        assertEquals("ca-app-pub-5222053984568989/1364015068", com.example.ads.AdConfig.INTERSTITIAL_AD_UNIT_ID)
        assertTrue(com.example.ads.AdConfig.isAdsEnabled)
    }
}
