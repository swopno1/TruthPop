package com.example.ads

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Clean, safe AdMob Banner View for Jetpack Compose.
 * Displays standard test banner at the bottom of the screen without obscuring game actions.
 */
@Composable
fun AdBannerView(
    modifier: Modifier = Modifier
) {
    if (!AdConfig.isAdsEnabled) return

    Box(
        modifier = modifier
            .fillMaxWidth()
            .testTag("ad_banner_container")
            .padding(vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("admob_banner_view"),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = AdConfig.getBannerAdUnitId()
                    val adRequest = AdRequest.Builder().build()
                    loadAd(adRequest)
                }
            }
        )
    }
}
