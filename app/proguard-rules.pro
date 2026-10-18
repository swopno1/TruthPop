# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Disable aggressive bytecode optimization to prevent runtime crashes in Compose reflection
-dontoptimize

# Keep all com.example application classes and constructors
-keep class com.example.** { *; }
-keep interface com.example.** { *; }

# Keep ViewModel constructors for reflection by ViewModelProvider
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

# Keep Compose internal functions and classes
-keep class androidx.compose.** { *; }

# Keep Google Play Services and AdMob
-keep class com.google.android.gms.** { *; }
-keep interface com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# Preserve annotations, signatures, and line numbers for crash diagnostics
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile
