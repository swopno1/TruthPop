# Changelog

All notable changes to the **TruthPop – Truth or Dare** application will be documented in this file.

## [4.0.0] - 2026-11-10

### Added
- **UMP Consent Gating:** Google User Messaging Platform consent flow gates all ads; declining users never initialize the Mobile Ads SDK.
- **Preferences Persistence:** Language, haptics, and favorites now persist across restarts via DataStore.
- **Play Store Link in Shares:** Every shared prompt ends with a one-tap install link.
- **Compliance Docs:** `GOOGLE_PLAY_DECLARATIONS.md`, `EU_TRADE_POLICY_COMPLIANCE.md`, root `TruthPop_PlayStore_Details.md` (EN + BN listings), `ANDROID_AUDIT_REPORT.md`, `PRODUCTION_READINESS.md`.
- **Gradle Wrapper:** Committed `gradlew` + `gradle-wrapper.jar` (Gradle 9.9.0); debug keystore generated for local builds.
- **Strict Lint Gate:** `checkReleaseBuilds = true`, `abortOnError = true`.

### Changed
- **Dependency Upgrades:** AGP 9.5.1, Kotlin 2.4.21, Compose BOM 2026.09.00, Gradle 9.9.0, play-services-ads 25.5.0, UMP 4.0.0, lifecycle 2.11.0, coroutines 1.11.0, Robolectric 4.17, compileSdk 37.
- **Dependency Pruning:** Removed unused fragment-ktx, KSP, secrets plugin, Firebase remnants, Coil references, and unused test libraries.
- **Per-Variant Ad Units:** Debug builds use Google demo units; release builds use production units (`.../1274631134` banner, `.../1364015068` interstitial).
- **Namespace:** `com.example` → `com.vivescriptsolutions.truthpop` (applicationId unchanged).
- **Release Signing:** Keystore passwords via environment or gitignored `local.properties` only; fail-fast errors on release builds.
- **Localization:** Card category/intensity labels, About dialog, and player picker fully bilingual (EN/BN).
- **About Dialog:** Version from `BuildConfig`, honest ad-data disclosure.
- **Language Toggle:** 48dp touch target with proper button semantics.
- **Banner:** Respects navigation-bar insets on edge-to-edge devices.
- **Manifest:** Added `AD_ID` permission for AdMob; fully-qualified activity name.
- **Listing Honesty:** "100% offline" → offline gameplay + free with ads; tags cut to the allowed 5; stale "zero tracking" claims removed.

### Fixed
- **Player Chip Close Target:** 18dp → 28dp.
- **Dead Resources:** Removed unused template colors and fake `google_app_id`/`gcm_defaultSenderId` placeholders; icon art moved to `drawable-nodpi/`.
- **Stale Docs:** Retired `FINAL_RELEASE_AUDIT.md` (v1.0-era) in favor of `ANDROID_AUDIT_REPORT.md`.

### Security
- No keystores or passwords in git; release signing requires local secrets only.

## [3.0.0] - 2026-10-16

### Changed & Optimized
- **Play Store Memory Standards Compliance:** Optimized app drawables by resizing icon raster assets and removing unreferenced high-resolution images, reducing bitmap heap memory footprint by over 130MB.
- **SDK Modernization:** Upgraded `androidx.fragment:fragment` to `1.8.6` across the runtime classpath, resolving Google Play SDK Console deprecation notices.
- **Ad Lifecycle Resource Management:** Integrated lifecycle-aware pause/resume handlers into `AdBannerView` to free rendering buffers while in the background.

## [1.0.0] - 2026-10-09

### Added
- **Instant Gameplay Engine:** Single-tap Truth and Dare generator with randomized prompt selection and history tracking to prevent prompt repetition.
- **Three Curated Categories:** Friends, Couples, and Family modes with dedicated age-appropriate content decks.
- **Three Intensity Levels:** Chill (warm-up), Fun (classic party), and Spicy (bold & cheeky).
- **Dual Language Support:** Full instant bilingual support for English and Bangla (বাংলা) with a single tap.
- **Pass-and-Play Turn Picker:** Party member turn tracking and random player spinner for group gatherings.
- **Safe & Consensual Design:** Pressure-free play with skip buttons on every prompt; excluded dangerous stunts, humiliation, and sexually explicit content.
- **Native Android Sharing:** One-tap sharing of customized prompt challenge cards to social platforms via Android's native share sheet.
- **Tactile Haptic Feedback:** Vibratory pop feedback on prompt reveal and button actions with user toggle control.
- **AdMob Integration:** Production AdMob App ID (`ca-app-pub-5222053984568989~4125909776`), Banner Ad Unit (`ca-app-pub-5222053984568989/1274631134`), and Interstitial Ad Unit (`ca-app-pub-5222053984568989/1364015068`) with respectful frequency capping.
- **High-Contrast Card Visibility:** Deep Navy Charcoal text (`#0F172A`), enhanced font sizing (24sp headline / 17sp translation), and distinct badge styling for crystal-clear readability against light card backgrounds.
- **Complete Compliance & Store Assets:** Play Store metadata, privacy policy, terms of service, data safety guide, 512x512 app icon, 1024x500 feature graphic, and phone/tablet screenshots.
