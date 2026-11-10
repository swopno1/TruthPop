# Google Play Data Safety Guidance — TruthPop

**Application:** TruthPop – Truth or Dare  
**Package:** `com.vivescriptsolutions.truthpop`  
**Publisher:** ViveScript Solutions LLC  
**SDKs Used:** Google Mobile Ads SDK (`play-services-ads:25.5.0`), Google UMP (`user-messaging-platform:4.0.0`)  
**Last Updated:** November 10, 2026 (Version 4.0)

---

## 1. Overview of Data Practices

TruthPop is an **offline-first local party game**. The application does NOT collect, maintain, or transmit user account data, personal identity records, contacts, or location data. Gameplay preferences (language, haptics, favorites) stay in on-device storage only.

The only external network communication occurs via the **Google Mobile Ads SDK (AdMob)** to serve banner and interstitial advertisements when an internet connection is available. Ads initialize only after Google UMP consent clearance; users who decline (EEA/UK) never load the SDK.

---

## 2. Google Play Console Data Safety Questionnaire Answers

### Does your app collect or share any of the required user data types?
- **Yes** (Solely through the Google Mobile Ads SDK).

### Is all of the user data collected by your app encrypted in transit?
- **Yes** (AdMob SDK enforces HTTPS/TLS encryption for all network requests).

### Do you provide a way for users to request that their data be deleted?
- **No** (No user accounts or personal profiles are created or maintained; users can reset/delete their advertising ID in Android Settings → Privacy → Ads).

---

## 3. Data Types Classification (AdMob SDK)

| Data Category | Data Type | Collected? | Shared? | Purpose | Ephemeral? |
|---|---|---|---|---|---|
| **Location** | Approximate Location (network-based) | Optional / Yes (via AdMob) | Yes (to Google) | Advertising or marketing, Fraud prevention | Yes |
| **App Activity** | App interactions, Page views | Yes (via AdMob) | Yes (to Google) | Analytics, Advertising | Yes |
| **App Info & Performance** | Crash logs, Diagnostics, Latency | Yes (via AdMob) | Yes (to Google) | Analytics, Diagnostics | Yes |
| **Device or other IDs** | Advertising ID (AAID) | Yes (via AdMob) | Yes (to Google) | Advertising, Fraud prevention | No (user resettable) |

*Note: No Personal Information (Name, Email, Phone, Address), Financial Info, Health Info, Messages, Photos, Audio, or Contacts are collected. The `AD_ID` permission is declared in the manifest for AdMob.*

---

## 4. Ads Declaration in Google Play Console
- Under **App Content > Ads**: Select **"Yes, my app contains ads"**.
- Declare AdMob banner and interstitial formats.
- Under **Advertising ID**: Select **"Yes"** → purpose **Advertising or marketing**.
- Target age group: 13 and above.
