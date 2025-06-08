# Common ProGuard/R8 rules for all modules in Chevit-Android project
# Based on AGP 8.10+ and modern Android libraries
# Created: 2025
# Usage: Include this file in all modules that need ProGuard/R8 rules

# ===== ESSENTIAL ATTRIBUTES =====
-keepattributes SourceFile,LineNumberTable
-keepattributes RuntimeVisibleAnnotations,RuntimeVisibleParameterAnnotations
-keepattributes Signature,InnerClasses,EnclosingMethod
-keepattributes *Annotation*

# Security: Hide the original source file name
-renamesourcefileattribute SourceFile

# ===== HILT DEPENDENCY INJECTION =====
# Official Hilt ProGuard rules
-dontwarn com.google.dagger.hilt.processor.internal.**
-dontwarn dagger.hilt.processor.internal.**
-dontwarn dagger.hilt.android.internal.testing.**
-dontwarn dagger.hilt.android.internal.managers.**

# Keep Hilt generated classes
-keep class dagger.hilt.** { *; }
-keep class * extends dagger.hilt.android.internal.managers.** { *; }
-keep class **_HiltComponents$** { *; }
-keep class **_GeneratedInjector { *; }
-keep class **_HiltModule { *; }
-keep class **_HiltWrapper { *; }

# Keep classes with Hilt annotations
-keep @dagger.hilt.android.AndroidEntryPoint class * { *; }
-keep @dagger.hilt.InstallIn class * { *; }
-keep @dagger.Module class * { *; }
-keep @javax.inject.Singleton class * { *; }

# HiltViewModel specific
-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel

# ===== RETROFIT 2 =====
# Official Retrofit 2 ProGuard rules
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Keep API interfaces
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8

# ===== OKHTTP 3/4 =====
# Official OkHttp ProGuard rules (automatically applied in modern versions)
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform
-dontwarn org.conscrypt.ConscryptHostnameVerifier

# ===== KOTLINX SERIALIZATION =====
# Official kotlinx.serialization ProGuard rules
-keepattributes InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt

# kotlinx-serialization-json specific
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep @Serializable classes
-keep,includedescriptorclasses class com.dkin.chevit.**$$serializer { *; }
-keepclassmembers class com.dkin.chevit.** {
    *** Companion;
}
-keepclasseswithmembers class com.dkin.chevit.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# New kotlinx.serialization rules for R8
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}

# ===== FIREBASE =====
# Official Firebase ProGuard rules
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.firebase.**
-dontwarn com.google.android.gms.**

# Firebase specific services
-keep class com.google.firebase.analytics.** { *; }
-keep class com.google.firebase.crashlytics.** { *; }
-keep class com.google.firebase.perf.** { *; }
-keep class com.google.firebase.messaging.** { *; }
-keep class com.google.firebase.auth.** { *; }

# ===== JETPACK COMPOSE =====
# Official Compose ProGuard rules
-keep class androidx.compose.runtime.** { *; }
-dontwarn androidx.compose.**

# Keep Compose Compiler generated classes
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.foundation.** { *; }
-keep class androidx.compose.material.** { *; }
-keep class androidx.compose.material3.** { *; }

# Keep CompositionLocal providers
-keepclassmembers class androidx.compose.** {
    *** provided*;
}

# ===== COIL IMAGE LOADING =====
# Official Coil ProGuard rules
-keep class coil.** { *; }
-keep interface coil.** { *; }
-dontwarn coil.**

# Coil-specific for different image sources
-keep class coil.fetch.** { *; }
-keep class coil.decode.** { *; }

# ===== LOTTIE =====
# Official Lottie ProGuard rules
-keep class com.airbnb.lottie.** { *; }
-dontwarn com.airbnb.lottie.**

# ===== ANDROID JETPACK =====
# Navigation Component
-keep class androidx.navigation.** { *; }
-keep class * extends androidx.fragment.app.Fragment
-keepnames class androidx.navigation.fragment.NavHostFragment

# Lifecycle
-keep class androidx.lifecycle.** { *; }
-keep class * implements androidx.lifecycle.LifecycleObserver {
    <init>(...);
}
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
-keepclassmembers class ** {
    @androidx.lifecycle.OnLifecycleEvent *;
}

# Room (if used)
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }

# DataStore
-keep class androidx.datastore.** { *; }
-dontwarn androidx.datastore.**

# ===== KOTLIN COROUTINES =====
# Official Kotlin Coroutines ProGuard rules
-keep class kotlin.coroutines.Continuation
-keep class kotlin.coroutines.jvm.internal.DebugMetadata { *; }
-keepclassmembers class kotlin.coroutines.SafeContinuation {
    volatile <fields>;
}

# Keep names for debugging coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# ===== JAVA 9+ STRING CONCATENATION =====
# Required for Kotlin string templates and toString() methods
-dontwarn java.lang.invoke.StringConcatFactory

# ===== STANDARD ANDROID CLASSES =====
# Application
-keep public class * extends android.app.Application

# Activities, Services, Receivers
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Custom Views
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Fragment
-keep public class * extends androidx.fragment.app.Fragment
-keepclassmembers class * extends androidx.fragment.app.Fragment {
    public *;
}

# Parcelable
-keep interface android.os.Parcelable
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# ===== PROJECT SPECIFIC CLASSES =====
# Core module classes (MVI framework and base classes)
-keep class com.dkin.chevit.core.mvi.** { *; }
-keep class com.dkin.chevit.core.base.** { *; }

# Keep data classes and models (for serialization only)
-keep,allowobfuscation,allowshrinking class com.dkin.chevit.data.model.** { *; }
-keep,allowobfuscation,allowshrinking class com.dkin.chevit.domain.model.** { *; }

# Keep presentation module classes that are referenced cross-module
-keep class com.dkin.chevit.presentation.deeplink.** { *; }
-keep class com.dkin.chevit.presentation.common.** { *; }
-keep class com.dkin.chevit.presentation.resource.** { *; }

# Keep UI entry points (Activities, Fragments, Services)
-keep public class * extends android.app.Activity
-keep public class * extends androidx.fragment.app.Fragment
-keep public class * extends android.app.Service

# Keep ViewModel classes (accessed via reflection by Hilt)
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

# Keep dependency injection modules and components  
-keep @dagger.Module class * { *; }
-keep @dagger.hilt.InstallIn class * { *; }
-keep @javax.inject.Singleton class * { *; }

# ===== REMOVE DEBUG LOGGING =====
# Remove all Log calls in release builds
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
    public static int wtf(...);
}

# Timber logging (if used)
-assumenosideeffects class timber.log.Timber* {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# ===== R8 OPTIMIZATIONS =====
# Disable aggressive optimizations for stability
# These can be enabled later for better optimization:
# -allowaccessmodification
# -repackageclasses 