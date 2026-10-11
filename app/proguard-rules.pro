# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep data models
-keep class com.example.model.** { *; }

# Keep AdMob classes & interfaces
-keep class com.google.android.gms.ads.** { *; }
-keep interface com.google.android.gms.ads.** { *; }

# Preserve line numbers and source file names for Google Play Console deobfuscation
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile
