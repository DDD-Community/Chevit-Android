buildscript {
    dependencies {
        classpath(libs.classpath.kotlin)
        classpath(libs.classpath.protobuf)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.com.google.ksp) apply false
    alias(libs.plugins.com.google.protobuf) apply false

    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.org.jetbrains.kotlin.serialization) apply false

    alias(libs.plugins.com.google.dagger.hilt) apply false
    alias(libs.plugins.com.androidx.navigation.safeArgs) apply false

    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.firebase.performance) apply false
}
true
