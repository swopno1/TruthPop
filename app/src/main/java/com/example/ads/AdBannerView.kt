package com.example.ads

import android.view.View
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

/**
 * Clean, safe, crash-resilient AdMob Banner View for Jetpack Compose.
 * Uses a fresh View factory per composition with comprehensive exception handling
 * so ad or webview failures never cause app crashes on real devices.
 */
@Composable
fun AdBannerView(
    modifier: Modifier = Modifier
) {
    if (!AdConfig.shouldServeAds()) return

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
                try {
                    AdView(context).apply {
                        setAdSize(AdSize.BANNER)
                        adUnitId = AdConfig.getBannerAdUnitId()
                        adListener = object : AdListener() {
                            override fun onAdFailedToLoad(error: LoadAdError) {
                                // Silent safe handling on network/ad inventory absence
                            }
                        }
                        loadAd(AdRequest.Builder().build())
                    }
                } catch (_: Throwable) {
                    // Safe blank placeholder if WebView or Google Play Services is missing
                    View(context)
                }
            },
            onRelease = { view ->
                try {
                    (view as? AdView)?.destroy()
                } catch (_: Throwable) {
                }
            }
        )
    }
}
