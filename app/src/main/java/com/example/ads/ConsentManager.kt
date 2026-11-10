package com.example.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import com.vivescriptsolutions.truthpop.BuildConfig

/**
 * Google User Messaging Platform (UMP) consent & privacy regulation manager.
 * Supports:
 * - European Economic Area (EEA) / UK GDPR consent messages
 * - US State regulations privacy messages (California, Virginia, Colorado, Connecticut, Utah, etc.)
 *   enabling users to opt out of the sale or sharing of their personal data.
 * - On-demand privacy options form triggered from the About / Settings dialog.
 */
object ConsentManager {
    private const val TAG = "ConsentManager"

    fun gatherConsent(activity: Activity, onComplete: (canRequestAds: Boolean) -> Unit) {
        val consentInfo = UserMessagingPlatform.getConsentInformation(activity)
        val paramsBuilder = ConsentRequestParameters.Builder()
            .setTagForUnderAgeOfConsent(false)

        if (BuildConfig.DEBUG) {
            val debugSettings = ConsentDebugSettings.Builder(activity)
                .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
                .build()
            paramsBuilder.setConsentDebugSettings(debugSettings)
        }

        consentInfo.requestConsentInfoUpdate(
            activity,
            paramsBuilder.build(),
            {
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) { formError ->
                    if (formError != null) {
                        Log.w(TAG, "Consent form load/show error: ${formError.message}")
                    }
                    onComplete(consentInfo.canRequestAds())
                }
            },
            { error ->
                Log.w(TAG, "Consent info update failed: ${error.message}")
                onComplete(BuildConfig.DEBUG || consentInfo.canRequestAds())
            }
        )
    }

    /**
     * Checks if a privacy options form (e.g. US State regulations opt-out or GDPR re-consent)
     * is required to be available to the user.
     */
    fun isPrivacyOptionsRequired(context: Context): Boolean {
        val consentInfo = UserMessagingPlatform.getConsentInformation(context)
        return consentInfo.privacyOptionsRequirementStatus ==
            ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
    }

    /**
     * Opens the Privacy Options form so users can review or change their privacy choices
     * (e.g. US State regulations opt-out, GDPR consent revision).
     */
    fun showPrivacyOptions(activity: Activity, onDismiss: () -> Unit = {}) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity) { formError ->
            if (formError != null) {
                Log.w(TAG, "Error displaying privacy options form: ${formError.message}")
            }
            onDismiss()
        }
    }
}
