# Android Audit Report — TruthPop v4.0

**Date:** November 10, 2026  
**Scope:** Full codebase, build system, ads stack, UI/UX, localization, store assets, and all Play compliance documents for `com.vivescriptsolutions.truthpop` v4 (4.0).  
**Method:** Static inspection of every source file + clean-room verification builds (`assembleDebug`, `testDebugUnitTest`, `lintDebug`), dex-level ad-unit proof, prompt-deck coverage analysis, and asset-dimension checks. No device was attached; on-device verification is pending (see §8).

---

## 1. Architecture & code health — PASS

- Single-Activity Compose/Material3 + MVVM/StateFlow, unidirectional data flow, no God objects. Largest file (`TruthPopApp.kt`, ~720 lines) is a single screen — acceptable.
- Prompt engine is pure functions over an immutable 50-item deck: full type×category×intensity cell coverage (18/18, min 2 prompts/cell), unique IDs, 100% EN+BN text and hints. No-recent-repeat + graceful fallback verified by tests.
- No backend, no accounts, no webviews, no reflection, no dynamic code loading. Gameplay state in memory; only language/haptics/favorites persist via DataStore (on-device, non-sensitive, covered by standard backup rules).

## 2. Build system & dependencies — PASS (modernized)

| Component | Before | After (latest stable, Maven-verified) |
|---|---|---|
| AGP | 9.1.1 | 9.5.1 |
| Kotlin | 2.2.10 | 2.4.21 |
| Gradle | 9.3.1 | 9.9.0 |
| Compose BOM | 2024.09.00 | 2026.09.00 |
| play-services-ads | 23.6.0 | 25.5.0 |
| UMP | absent | 4.0.0 |
| lifecycle | 2.8.7 | 2.11.0 |
| coroutines | 1.10.2 | 1.11.0 |
| datastore-preferences | absent | 1.3.0 (new: prefs persistence) |
| robolectric | 4.16.1 | 4.17 |
| compileSdk | 36.1 | 37 (target stays 36) |

- Removed: fragment-ktx, KSP plugin (was version-mismatched 2.3.5 vs Kotlin 2.2.10), secrets plugin, Firebase remnants, Coil references, espresso/compose-test/coroutines-test (no consumers), commented-out catalog cruft.
- Fixed: `namespace = "com.example"` → `com.vivescriptsolutions.truthpop` (applicationId unchanged); manifest uses fully-qualified activity; tests import new `R`/`BuildConfig`.
- Added: committed `gradlew` + wrapper jar, generated (gitignored) `debug.keystore`, strict lint gate (`checkReleaseBuilds`, `abortOnError`), env/`local.properties` release signing with fail-fast errors.

## 3. Ads stack — PASS (rebuilt for compliance)

- Per-variant ad units via `buildConfigField`: debug binary proven by dex scan to contain **only** Google demo units; release resolves production units (`.../1274631134`, `.../1364015068`).
- UMP `ConsentManager` gates all ads: no consent → SDK never initializes, banner/interstitial stay hidden. Failure paths always resolve (startup can never hang on consent).
- Banner honors consent reactively (`StateFlow`) and respects navigation-bar insets; interstitial throttled to ≤1 per 6 actions with exception-safe load/show.
- Manifest now declares `AD_ID` (matches privacy/data-safety claims); emulator serving still suppressed at runtime.

## 4. UI/UX — PASS with notes

- Verified statically (dark/light palettes, 48dp primary CTAs, scroll/rotation-safe layout, keyboard-safe player input, labeled share/copy actions). Fixed: language toggle 48dp, chip close 18→28dp, banner insets, About version from `BuildConfig`.
- Pending device confirmation: real-render check on small (360dp) and large screens, gesture vs 3-button nav, EN/BN visual sweep.

## 5. Localization — PASS

- All user-facing surfaces bilingual: prompt cards (incl. category/intensity labels — previously English-only), player picker, About dialog (previously English-only), share text.
- No `values-bn` (strings live inline with the in-app toggle by design); `app_name` stays identical per locale.
- Share text is now locale-correct (BN shares fully Bengali) and ends with a Play Store install link.

## 6. Permissions & security — PASS

- Manifest: `INTERNET`, `ACCESS_NETWORK_STATE`, `VIBRATE` (normal, user-toggleable), `AD_ID` — zero dangerous permissions. Single exported LAUNCHER activity, no deep links, no providers, no secrets in code/git, no keystores committed. ProGuard keeps are broad (`com.example.**`, compose) — safe, mildly size-suboptimal; left as-is for stability.

## 7. Store assets — PASS with action items

- Dimensions correct: 512 icon, 1024×500 graphic, 1080×1920 phones, 1920×1200 tablets. Icon on-brand; screenshot prompt text verified against the real deck.
- **Action required before upload:** re-export screenshots + feature graphic without alpha channel (currently RGBA); add ≥1 unedited real-UI capture per form factor (current phones are composites).

## 8. Verification evidence

- `assembleDebug` + `testDebugUnitTest` + `lintDebug`: **BUILD SUCCESSFUL**; 7/7 tests pass (deck integrity, filtering, ViewModel flows, launch, per-variant ad IDs); lint 0 errors (6 accepted cosmetic warnings: legacy-icon padding, targetSdk 36 note).
- Dex scan: debug APK contains demo units only. Release build correctly fail-fasts without the upload keystore (none exists in this checkout — expected).
- **Not run:** release/AAB build + signature (blocked on upload keystore + passwords), on-device pass (no device attached), Play Console form submission (human).

## 9. Fix list applied in v4.0

See `CHANGELOG.md` [4.0.0] for the full list (12 code files changed/added, 14 docs created/updated).
