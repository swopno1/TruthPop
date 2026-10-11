package com.example.ads

import android.os.Build

/**
 * Centralized AdMob advertising configuration.
 * Configured with user's registered AdMob App ID and Ad Unit IDs.
 */
object AdConfig {
    // Registered Google AdMob App ID
    const val APP_ID = "ca-app-pub-5222053984568989~4125909776"

    // Registered Banner Ad Unit ID
    const val BANNER_AD_UNIT_ID = "ca-app-pub-5222053984568989/1274631134"

    // Registered Interstitial Ad Unit ID
    const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-5222053984568989/1364015068"

    // Flag to enable/disable ads easily (e.g. for premium or offline testing)
    var isAdsEnabled: Boolean = true

    /**
     * Determines whether ads should actively load on the current runtime.
     * Prevents loading in headless / containerized emulators that lack
     * hardware DRM render nodes (/dev/dri/renderD128) and system AdServices
     * measurement daemons, avoiding system log errors.
     */
    fun shouldServeAds(): Boolean {
        return isAdsEnabled && !isEmulator()
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
     * Resolves the active banner ad unit ID.
     */
    fun getBannerAdUnitId(): String {
        return BANNER_AD_UNIT_ID
    }

    /**
     * Resolves the active interstitial ad unit ID.
     */
    fun getInterstitialAdUnitId(): String {
        return INTERSTITIAL_AD_UNIT_ID
    }
}
