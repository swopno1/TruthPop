package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ui.TruthPopApp
import com.example.ui.TruthPopViewModel
import com.example.ui.theme.TruthPopTheme
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {

    private val viewModel: TruthPopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Google Mobile Ads SDK asynchronously only if runtime supports ads
        if (com.example.ads.AdConfig.shouldServeAds()) {
            try {
                val requestConfig = com.google.android.gms.ads.RequestConfiguration.Builder()
                    .setTestDeviceIds(listOf(com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR))
                    .build()
                MobileAds.setRequestConfiguration(requestConfig)

                MobileAds.initialize(this) {
                    com.example.ads.InterstitialAdManager.loadAd(this@MainActivity)
                }
            } catch (_: Throwable) {
                // Keep app 100% playable even if Google Play Services is absent
            }
        }

        setContent {
            TruthPopTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TruthPopApp(viewModel = viewModel)
                }
            }
        }
    }
}
