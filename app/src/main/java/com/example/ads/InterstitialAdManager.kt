package com.example.ads

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

/**
 * Manages Google AdMob Interstitial Ads following official policies:
 * - Pre-loads ads in the background
 * - Respects user experience by showing only periodically (not on every click)
 * - Auto-reloads on dismiss or failure
 */
object InterstitialAdManager {

    private var interstitialAd: InterstitialAd? = null
    private var isLoading = false
    private var actionCount = 0
    private const val ACTIONS_BETWEEN_ADS = 6 // Polite frequency for party game sessions

    fun loadAd(context: Context) {
        if (!AdConfig.isAdsEnabled || isLoading || interstitialAd != null) return

        isLoading = true
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            context,
            AdConfig.getInterstitialAdUnitId(),
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isLoading = false
                    setupCallback(ad, context)
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitialAd = null
                    isLoading = false
                }
            }
        )
    }

    private fun setupCallback(ad: InterstitialAd, context: Context) {
        ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                interstitialAd = null
                loadAd(context)
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                interstitialAd = null
                loadAd(context)
            }
        }
    }

    fun onUserAction(activity: Activity?) {
        if (!AdConfig.isAdsEnabled || activity == null) return

        actionCount++
        if (actionCount >= ACTIONS_BETWEEN_ADS) {
            actionCount = 0
            if (interstitialAd != null) {
                interstitialAd?.show(activity)
            } else {
                loadAd(activity)
            }
        }
    }
}
