# Google Play Data Safety Guidance — TruthPop

**Application:** TruthPop – Truth or Dare  
**Package:** `com.vivescriptsolutions.truthpop`  
**Publisher:** ViveScript Solutions LLC  
**SDKs Used:** Google Mobile Ads SDK (`play-services-ads:23.6.0`)  

---

## 1. Overview of Data Practices

TruthPop is an **offline-first local party game**. The application does NOT collect, maintain, or transmit user account data, personal identity records, contacts, or location data.

The only external network communication occurs via the **Google Mobile Ads SDK (AdMob)** to serve banner advertisements when an internet connection is available.

---

## 2. Google Play Console Data Safety Questionnaire Answers

### Does your app collect or share any of the required user data types?
- **Yes** (Solely through the Google Mobile Ads SDK).

### Is all of the user data collected by your app encrypted in transit?
- **Yes** (AdMob SDK enforces HTTPS/TLS encryption for all network requests).

### Do you provide a way for users to request that their data be deleted?
- **Not applicable** (No user accounts or personal profiles are created or maintained).

---

## 3. Data Types Classification (AdMob SDK)

| Data Category | Data Type | Collected? | Shared? | Purpose | Ephemeral? |
|---|---|---|---|---|---|
| **Location** | Approximate Location (network-based) | Optional / Yes (via AdMob) | Yes (to Google) | Advertising or marketing, Fraud prevention | Yes |
| **App Activity** | App interactions, Page views | Yes (via AdMob) | Yes (to Google) | Analytics, Advertising | Yes |
| **App Info & Performance** | Crash logs, Diagnostics, Latency | Yes (via AdMob) | Yes (to Google) | Analytics, Diagnostics | Yes |
| **Device or other IDs** | Advertising ID (AAID) | Yes (via AdMob) | Yes (to Google) | Advertising, Fraud prevention | No (user resettable) |

*Note: No Personal Information (Name, Email, Phone, Address), Financial Info, Health Info, Messages, Photos, Audio, or Contacts are collected.*

---

## 4. Ads Declaration in Google Play Console
- Under **App Content > Ads**: Select **"Yes, my app contains ads"**.
- Declare AdMob banner and interstitial formats.
- Target age group: 13 and above.
