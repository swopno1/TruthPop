# Production Readiness — TruthPop v4.0

**Verdict: READY TO PROCEED** — ship the v4.0 AAB once the three human-side items below are done. No code blockers remain.

**Date:** November 10, 2026 · **Release:** v4 (4.0) · **Full evidence:** `ANDROID_AUDIT_REPORT.md`

---

## Scores

| Area | Score | Basis |
|---|---|---|
| Codebase health | 9/10 | Clean MVVM, full deck coverage, tested; broad ProGuard keeps cost 1 pt |
| Build & dependencies | 10/10 | Latest stable everything, strict lint gate, green builds |
| Ads & consent compliance | 10/10 | Demo/live split proven, UMP-gated, AD_ID consistent |
| UI/UX | 8/10 | Fixed targets/insets/persistence; −2 pending device confirmation |
| Localization (EN/BN) | 9/10 | Fully bilingual; inline-string design (no values-bn) costs 1 pt |
| Privacy/Data Safety/Declarations | 10/10 | Zero first-party collection; AdMob fully declared; docs consistent |
| Store listing & assets | 7/10 | Texts final + counted; −3 for alpha-channel + real-UI screenshot TODOs |
| Release engineering | 8/10 | Signing hygiene done; −2: AAB unsigned (keystore with human) |
| **Overall** | **9/10** | **Ready to proceed** |

---

## Human-side items (block AAB upload, not code-complete)

1. **Upload keystore + passwords** — place `my-upload-key.jks` in the project root (gitignored) and export `STORE_PASSWORD`/`KEY_PASSWORD` (or `local.properties`); then `./gradlew bundleRelease` and verify with `apksigner`.
2. **AdMob GDPR message** — create for `ca-app-pub-5222053984568989~4125909776`, else EEA ads stay off by design.
3. **Site pages** — publish privacy + terms at `/en/apps/truthpop/privacy` and `/en/apps/truthpop/terms`.
4. **Screenshots** — re-export without alpha; add ≥1 real-UI capture per form factor.
5. **Console forms** — fill from `GOOGLE_PLAY_DECLARATIONS.md`; answer the IARC questionnaire honestly (recommended Teen/13+ given romantic Couples content — human call).

## Pre-submit checklist

- [x] Debug + tests + lint green (7/7, 0 errors)
- [x] Demo-only units in debug (dex-proven)
- [x] Privacy/Terms/Data-Safety/Metadata/Declarations/EU docs consistent
- [x] Release notes EN+BN ≤500 chars (`release-notes-en.txt`, `release-notes-bn.txt`)
- [x] CHANGELOG [4.0.0] entry
- [ ] Release AAB built + `apksigner`-verified (needs keystore)
- [ ] Device smoke pass (needs hardware)
- [ ] Screenshots finalized + uploaded
- [ ] Console declarations submitted (human)
