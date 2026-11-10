# Google Play Console Declarations & Approval Master Reference

**App Name:** TruthPop – Truth or Dare  
**Package Name:** `com.vivescriptsolutions.truthpop`  
**Current Release:** Version Code `4`, Version Name `4.0`  
**Developer:** ViveScript Solutions LLC  
**Support Email:** privacy@vivescriptsolutions.com  
**Privacy Policy URL:** https://www.vivescriptsolutions.com/en/apps/truthpop/privacy  
**Terms of Service URL:** https://www.vivescriptsolutions.com/en/apps/truthpop/terms

---

## 1. App Access
**Question:** Is access to any part of your app restricted?  
**Selection:**  
`All functionality is available without special access`  
**Reviewer Notes (if requested):**  
> *"TruthPop is a single-screen offline party game. It requires no login credentials, username, password, subscription, or account. Reviewers can access 100% of the app immediately upon launch."*

---

## 2. Ads Declaration
**Question:** Does your app contain advertising?  
**Selection:**  
`Yes, my app contains ads`  
**Explanation for reviewers:** *"Google AdMob banner pinned to the bottom of the screen plus one interstitial shown at most once every 6 pop/skip actions. Ads are gated by Google UMP consent — users who decline see no ads. Debug builds use Google demo units; release builds use production units ca-app-pub-5222053984568989/1274631134 (banner) and ca-app-pub-5222053984568989/1364015068 (interstitial)."*

---

## 3. Advertising ID
**Question:** Does your app use advertising ID?  
**Selection:** `Yes`  
**Purpose:** `Advertising or marketing` (Google AdMob SDK; `AD_ID` permission declared in the manifest).

---

## 4. Content Rating Questionnaire (IARC)
- **Category:** Entertainment (party game)
- **Does the app share user-provided personal info with third parties?** `No` first-party (AdMob declared separately under Data Safety)
- **Does the app share physical location with other users?** `No`
- **Does the app allow users to purchase digital goods?** `No`
- **Suggestive / romantic themes:** Answer honestly — Couples decks contain playful romantic (non-explicit) prompts; Spicy intensity is cheeky but excludes sexual explicitness, per content policy in `PromptRepository.kt`.
- **Recommended Rating:** `Teen` / `PEGI 12` (13+). Do NOT select Everyone without re-answering the questionnaire honestly — human confirmation required.

---

## 5. Target Audience & Content
- **Target Age Group:** `13 and older`
- **Could the store listing unintentionally appeal to children?** `No` (party game positioned at teens/adults; Family deck is all-ages but the listing does not target young children)
- **Designed for Families:** `No` (opt out — ads + teen positioning)

---

## 6. Special Category Declarations
- **COVID-19 Contact Tracing or Status App:** `No`
- **Government App:** `No`
- **Financial Services / Crypto / Loans:** `No`
- **News App:** `No`
- **Health / Medical / Health Connect App:** `No`

---

## 7. Data Safety Form

### Overview
- **Data Collection:** `Yes` (Google Mobile Ads SDK: Device IDs + Diagnostics + App activity + Approximate location for advertising).
- **Data Sharing:** `Yes` (with Google for ad serving/reporting; no first-party sharing).
- **Data Encryption in Transit:** `Yes` (AdMob SDK uses HTTPS).
- **Data Deletion:** `No` (no accounts or first-party stored data; Ad ID is user-resettable in Android Settings).

### Data Types Declaration
| Data Category | Data Type | Collected | Shared | Ephemeral | Purpose |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Device or other IDs** | Device or other IDs (Ad ID) | Yes (AdMob SDK) | Yes (Google) | No (resettable) | Advertising or marketing |
| **App activity** | App interactions | Yes (AdMob SDK) | Yes (Google) | Yes | Advertising / Analytics (SDK-internal) |
| **App info and performance** | Diagnostics / Crash logs | Yes (AdMob SDK) | Yes (Google) | Yes | Advertising / Analytics (SDK-internal) |
| **Location** | Approximate location | Optional / Yes (AdMob SDK) | Yes (Google) | Yes | Advertising |
| **Personal Info** | Name / Email / Phone | **No** | No | N/A | None (no registration) |
| **Photos & Videos / Audio** | Media | **No** | No | N/A | None (no camera/mic/storage) |

---

## 8. Permissions Declarations

### 8.1 Internet (`INTERNET`)
- **Declaration Statement:**
```text
Used solely to load Google AdMob banner and interstitial ads and Google UMP consent messaging. Gameplay runs 100% on-device and works in airplane mode; no gameplay data is ever transmitted.
```

### 8.2 Network State (`ACCESS_NETWORK_STATE`)
- **Declaration Statement:**
```text
Used by the Google Mobile Ads SDK to check connectivity before requesting ads.
```

### 8.3 Vibrate (`VIBRATE`)
- **Declaration Statement:**
```text
Normal permission used for optional haptic pop feedback on card reveals, with an in-app on/off toggle. No vibration occurs when disabled.
```

### 8.4 Advertising ID (`com.google.android.gms.permission.AD_ID`)
- **Declaration Statement:**
```text
Used by the Google Mobile Ads SDK for ad serving and reporting. Users can reset or delete their advertising ID in Android Settings.
```

---

## 9. Reviewer Testing Guidance

```text
STEP-BY-STEP REVIEWER TESTING INSTRUCTIONS:

1. Launch TruthPop on any test device or emulator.
2. A UMP consent form may appear; accept or dismiss it (dismissing disables ads).
3. Tap TRUTH / DARE / RANDOM, pick a category chip and intensity chip, then tap POP NEXT to reveal prompts.
4. Toggle the top-bar language switch (EN / বাং) to verify both UI languages.
5. Tap the Group icon to add players and spin for the next turn.
6. Tap the Share button on any prompt card to open the Android share sheet (interstitial may show first, max once per 6 actions).
7. Tap the Info icon for the About dialog (version, license, privacy summary).
8. Enable airplane mode to verify gameplay works fully offline (ads will not load).
```

---

## 10. Copy-Paste Appeal Templates

### Appeal for Data Safety / Privacy Inquiry:
> **Subject:** Clarification on Data Safety Declaration - `com.vivescriptsolutions.truthpop`  
> **Dear Google Play Review Team,**  
> TruthPop is a single-screen offline party game. It collects no first-party data: no accounts, no analytics, no crash SDK, no servers — gameplay runs in on-device memory and preferences. The only collection comes from the embedded Google Mobile Ads SDK (Advertising ID + diagnostics + app activity), declared accordingly, encrypted in transit, and gated by Google UMP consent so declined users never load ads.

### Appeal for Ads / Interstitial Inquiry:
> **Subject:** Clarification on Interstitial Ads - `com.vivescriptsolutions.truthpop`  
> **Dear Google Play Review Team,**  
> TruthPop shows at most one interstitial per 6 pop/skip actions, only after an explicit user tap, and gameplay always continues after dismissal. The persistent banner sits in a fixed bottom bar above the navigation bar and never overlaps interactive content. Both formats are gated by UMP consent.

---

## 11. EU Digital Services Act (DSA) & Trader Status Declaration

Google Play requires all developers distributing in the European Economic Area (EEA) to declare their trader status under **Policy and programs > Trader status**:

- **Recommended Selection:** **"Yes, I am a trader"** (for ViveScript Solutions LLC)  
  - Legal Name: `ViveScript Solutions LLC`
  - Email: `privacy@vivescriptsolutions.com`
  - Website: `https://www.vivescriptsolutions.com/`
  - Address: `1209 Orange Street, Wilmington, DE 19801, USA`
- See full legal analysis in `EU_TRADE_POLICY_COMPLIANCE.md`.
