package com.example.ads

import android.os.Build
import com.vivescriptsolutions.truthpop.BuildConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Centralized AdMob advertising configuration.
 *
 * The manifest carries the production AdMob App ID (required: the SDK
 * refuses to init without the ID the store listing is linked to).
 * Test safety comes from the ad units instead: debug builds request
 * Google's demo units, release builds the production units below, and
 * no ad loads until UMP consent clearance flips [canShowAds].
 */
object AdConfig {
    // Registered Google AdMob App ID
    const val APP_ID = "ca-app-pub-5222053984568989~4125909776"

    // Ad units are injected per build variant (see app/build.gradle.kts):
    // Google demo units in debug, registered production units in release.
    // A debug binary therefore never even contains the live unit strings.

    // Flag to enable/disable ads easily (e.g. for premium or offline testing)
    var isAdsEnabled: Boolean = true

    /**
     * True once UMP consent clearance is granted and Mobile Ads is
     * initialized. Banners and interstitials stay fully hidden until then
     * (e.g. EEA users who decline consent never see ad slots).
     */
    var canShowAds: Boolean = false
        private set
    private val _canShowAdsFlow = MutableStateFlow(false)
    val canShowAdsFlow: StateFlow<Boolean> = _canShowAdsFlow.asStateFlow()

    fun setCanShowAds(value: Boolean) {
        canShowAds = value
        _canShowAdsFlow.value = value
    }

    /**
     * Determines whether ads should actively load on the current runtime.
     * Prevents loading in headless / containerized emulators that lack
     * hardware DRM render nodes (/dev/dri/renderD128) and system AdServices
     * measurement daemons, avoiding system log errors.
     */
    fun shouldServeAds(): Boolean {
        return isAdsEnabled && canShowAds && !isEmulator()
    }

    /**
     * Identifies if running in an Android emulator.
     */
    fun isEmulator(): Boolean {
        val fingerprint = Build.FINGERPRINT.lowercase()
        val model = Build.MODEL.lowercase()
        val hardware = Build.HARDWARE.lowercase()
        val product = Build.PRODUCT.lowercase()
        val manufacturer = Build.MANUFACTURER.lowercase()
        val brand = Build.BRAND.lowercase()
        val device = Build.DEVICE.lowercase()

        return fingerprint.startsWith("generic")
                || fingerprint.startsWith("unknown")
                || model.contains("google_sdk")
                || model.contains("emulator")
                || model.contains("android sdk built for")
                || hardware.contains("goldfish")
                || hardware.contains("ranchu")
                || product.contains("sdk")
                || product.contains("google_sdk")
                || product.contains("emulator")
                || manufacturer.contains("genymotion")
                || brand.startsWith("generic")
                || device.startsWith("generic")
    }

    /**
     * Resolves the active banner ad unit ID (demo in debug, live in release).
     */
    fun getBannerAdUnitId(): String = BuildConfig.ADMOB_BANNER_AD_UNIT_ID

    /**
     * Resolves the active interstitial ad unit ID (demo in debug, live in release).
     */
    fun getInterstitialAdUnitId(): String = BuildConfig.ADMOB_INTERSTITIAL_AD_UNIT_ID
}
