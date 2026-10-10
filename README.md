# TruthPop – Truth or Dare

> A fun, colorful, and lightweight Truth or Dare party game generator for friends, couples, and families with instant offline prompts in English and Bangla.

**Developed by:** [ViveScript Solutions LLC](https://www.vivescriptsolutions.com/)  
**Copyright:** © 2026 ViveScript Solutions LLC.  
**Package:** `com.vivescriptsolutions.truthpop`  

---

## Overview

**TruthPop** makes playing Truth or Dare effortless, engaging, and enjoyable at any gathering. With a single tap, players reveal creative questions or daring challenges on a beautifully animated party card. Designed for instant access, TruthPop functions completely offline with zero account creation, logins, or backend servers required.

### Target Users & Use Cases
- **Friends & House Parties:** Icebreakers, hilarious stories, and friendly group dares.
- **Couples & Date Nights:** Playful romantic bonding and sweet confessions.
- **Family Gatherings:** Wholesome, clean, all-ages laughs for kids, parents, and grandparents.
- **Bilingual Social Groups:** South Asian and global friend circles looking for seamless English and Bangla (বাংলা) prompts.

---

## Key Features

- **Instant Truth or Dare Engine:** Reveal random prompts instantly with smart deck filtering and history tracking to prevent repetitive questions.
- **Three Curated Categories:**
  - 👥 **Friends:** Party icebreakers, quirky confessions, and friendly dares.
  - ❤️ **Couples:** Romantic, sweet, and intimate bonding challenges.
  - 👨‍👩‍👧‍👦 **Family:** Wholesome, clean, laugh-out-loud fun suitable for all ages.
- **Three Intensity Levels:**
  - 🟢 **Chill:** Gentle warm-ups.
  - 🟡 **Fun:** Classic party vibes.
  - 🔴 **Spicy:** Bold, cheeky, and high-energy questions and dares.
- **Instant English & Bangla Bilingual Switching:** Switch between English and Bangla translations with a single tap in the top bar.
- **Party Turn Picker:** Add players' names to the party list and spin the wheel or tap to pick who takes the next turn.
- **Pressure-Free & Consensual:** Every dare is optional. Players can skip any card freely with zero penalties or social pressure.
- **Native Social Sharing:** Share custom-styled prompt challenges directly to WhatsApp, Instagram, Messenger, X, or SMS via Android's native share sheet.
- **Haptic Pop Feedback:** Tactile vibration effects on card reveals with an instant on/off toggle.
- **Offline-First Architecture:** Complete prompt library is stored locally on the device—no internet connection required to play.
- **AdMob Integration:** Non-intrusive banner ads powered by Google Mobile Ads SDK with centralized configuration (`AdConfig`).

---

## Technology Stack

- **Language:** Kotlin 2.2.10
- **UI Framework:** Jetpack Compose with Material 3 (M3)
- **Architecture:** MVVM (Model-View-ViewModel) with StateFlow
- **Advertising:** Google Mobile Ads SDK (`com.google.android.gms:play-services-ads:23.6.0`)
- **Image Loading:** Coil Compose
- **Testing:** JUnit 4 & Robolectric
- **Build System:** Gradle (Kotlin DSL) with Version Catalogs (`libs.versions.toml`)

---

## Requirements

- **Minimum SDK:** Android API 24 (Android 7.0 Nougat)
- **Target SDK:** Android API 36
- **JDK:** Java 11 / Java 17
- **Android Studio:** Ladybug (2024.2) or newer

---

## Project Structure

```text
├── app/
│   ├── build.gradle.kts                # App-level build and dependencies
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml     # Manifest, permissions, and AdMob metadata
│       │   ├── java/com/example/
│       │   │   ├── MainActivity.kt     # App entry point with edge-to-edge
│       │   │   ├── ads/                # AdMob configuration and banner views
│       │   │   ├── data/               # Curated offline prompt repository
│       │   │   ├── model/              # Data models (PromptItem, Category, Intensity)
│       │   │   ├── ui/                 # Jetpack Compose UI (TruthPopApp, ViewModel)
│       │   │   │   ├── components/     # AboutDialog, PlayerPickerSheet
│       │   │   │   └── theme/          # Party color palette and Material 3 theme
│       │   │   └── util/               # HapticHelper vibrator utilities
│       │   └── res/                    # Drawables, mipmaps, strings, and XML
│       └── test/java/com/example/      # Unit and Robolectric tests
├── gradle/libs.versions.toml           # Dependency version catalog
├── play_store_assets/                  # Google Play icon, feature graphic & screenshots
├── production_build/                   # Release Android App Bundle (.aab)
├── README.md                           # Project documentation
├── LICENSE                             # MIT license + proprietary branding notice
├── PRIVACY_POLICY.md                   # Privacy policy
├── TERMS_OF_SERVICE.md                 # Terms of service
├── PLAY_STORE_METADATA.md              # Store listings, descriptions, and keywords
├── PLAY_STORE_DATA_SAFETY.md           # Play Console data safety answers
├── DESIGN_ASSETS.md                    # Visual identity specifications
└── CHANGELOG.md                        # Version release history
```

---

## Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/vivescriptsolutions/truthpop.git
   cd truthpop
   ```
2. **Open in Android Studio:**
   - Launch Android Studio and choose **Open an Existing Project**.
   - Select the cloned directory.
3. **Sync Gradle:**
   - Wait for Gradle to download dependencies and sync automatically.
4. **Run on Device or Emulator:**
   - Select your target device or emulator and click **Run (Shift + F10)**.

---

## Build Commands

To build via terminal:

- **Debug APK:**
  ```bash
  gradle :app:assembleDebug
  ```
- **Release App Bundle (AAB):**
  ```bash
  gradle :app:bundleRelease
  ```

---

## Testing

The project includes JVM unit and Robolectric tests validating prompt deck integrity, category/intensity filters, bilingual text availability, and ViewModel state transitions:

```bash
gradle :app:testDebugUnitTest
```

---

## Privacy & Data Safety

- **Zero Tracking:** The app does not collect personal identifiers, passwords, contacts, or location data.
- **100% Offline Core:** All prompts and party game logic operate on the device without remote servers.
- **Advertising:** Standard non-intrusive AdMob banner and polite interstitial ads powered by Google Mobile Ads SDK with registered App ID (`ca-app-pub-5222053984568989~4125909776`), Banner Unit (`ca-app-pub-5222053984568989/1274631134`), and Interstitial Unit (`ca-app-pub-5222053984568989/1364015068`).
- For complete details, see [PRIVACY_POLICY.md](PRIVACY_POLICY.md) and [PLAY_STORE_DATA_SAFETY.md](PLAY_STORE_DATA_SAFETY.md).

---

## License & Copyright

© 2026 ViveScript Solutions LLC.

The source code is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for complete details.

**Proprietary Branding Notice:**  
The app name ("TruthPop"), logo, custom app icons, screenshots, feature graphics, trademarks, and associated branding are proprietary property of ViveScript Solutions LLC and are **not** licensed under the MIT License.
