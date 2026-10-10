package com.example.ads

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
