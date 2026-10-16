package com.example.ads

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Clean, safe, memory-optimized AdMob Banner View for Jetpack Compose.
 * Manages view lifecycle (pause/resume/destroy) to release bitmap and GPU buffers
 * when the app is in the background or navigating away.
 */
@Composable
fun AdBannerView(
    modifier: Modifier = Modifier
) {
    if (!AdConfig.shouldServeAds()) return

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val adView = remember {
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = AdConfig.getBannerAdUnitId()
            adListener = object : com.google.android.gms.ads.AdListener() {
                override fun onAdFailedToLoad(error: com.google.android.gms.ads.LoadAdError) {
                    // Gracefully handled for offline/emulator environments
                }
            }
            try {
                loadAd(AdRequest.Builder().build())
            } catch (_: Throwable) {
                // Resilient fallback if render nodes or codecs unavailable
            }
        }
    }

    DisposableEffect(lifecycleOwner, adView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> adView.resume()
                Lifecycle.Event.ON_PAUSE -> adView.pause()
                Lifecycle.Event.ON_DESTROY -> adView.destroy()
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            try {
                adView.destroy()
            } catch (_: Throwable) {
            }
        }
    }

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
            factory = { adView },
            onRelease = { view ->
                try {
                    view.destroy()
                } catch (_: Throwable) {
                }
            }
        )
    }
}
