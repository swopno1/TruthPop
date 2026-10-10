# Design & Visual Assets Specification — TruthPop

**App Name:** TruthPop – Truth or Dare  
**Package:** `com.vivescriptsolutions.truthpop`  
**Publisher:** ViveScript Solutions LLC  
**Copyright:** © 2026 ViveScript Solutions LLC.  

---

## 1. Brand Identity & Visual Language

TruthPop is crafted with an energetic, candy-pop, vibrant party game aesthetic. It pairs electric violet, neon pink, energetic cyan, and fiery orange accents against high-contrast surfaces to create an inviting, playful experience.

### Brand Color Palette
- **Primary Brand Color (Electric Violet):** `#7C4DFF`
- **Secondary Brand Color (Neon Pink):** `#FF4081`
- **Truth Accent (Electric Cyan):** `#00B0FF` / `#00E5FF`
- **Dare Accent (Sunset Orange):** `#FF6D00` / `#FF3D00`
- **Icon Solid Background:** `#4A148C` (Deep Violet)
- **Dark Night Surface:** `#120B24` / `#1E1438`
- **Light Candy Surface:** `#F9F6FE` / `#FFFFFF`

---

## 2. Launcher Icon Architecture

- **Adaptive Icon Foreground:** `app/src/main/res/drawable/ic_launcher_foreground.xml` (layer-list centering `img_truthpop_icon` within a 66dp safe zone)
- **Adaptive Icon Background:** `app/src/main/res/drawable/ic_launcher_background.xml` (solid `#4A148C`)
- **Density Mipmaps:** Full PNG32 raster fallbacks across all five standard density folders:
  - `mipmap-mdpi/`: 48 × 48 px (`ic_launcher.png`, `ic_launcher_round.png`)
  - `mipmap-hdpi/`: 72 × 72 px (`ic_launcher.png`, `ic_launcher_round.png`)
  - `mipmap-xhdpi/`: 96 × 96 px (`ic_launcher.png`, `ic_launcher_round.png`)
  - `mipmap-xxhdpi/`: 144 × 144 px (`ic_launcher.png`, `ic_launcher_round.png`)
  - `mipmap-xxxhdpi/`: 192 × 192 px (`ic_launcher.png`, `ic_launcher_round.png`)

---

## 3. Store Marketing Assets

Store assets are organized under `/play_store_assets/`:
- **App Icon:** `play_store_assets/app-icon/app-icon.png` (512 × 512 px)
- **Feature Graphic:** `play_store_assets/feature-graphic/feature-graphic.png` (1024 × 500 px)
- **Phone Previews:** `play_store_assets/phone/` (1080 × 1920 px)
- **Tablet Previews:** `play_store_assets/tablet/` (1920 × 1200 px)

---

## 4. Typography & Icons
- **Primary Typography:** System Material 3 typography scale (HeadlineLarge, TitleMedium, BodyMedium, LabelLarge).
- **Iconography:** Official Android Material Symbols & Icons Extended (`Icons.Filled`, `Icons.Outlined`).
