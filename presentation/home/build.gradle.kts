@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

apply(from = project.rootProject.file("gradle-scripts/base.gradle"))
apply(from = project.rootProject.file("gradle-scripts/compose.gradle"))
apply(from = project.rootProject.file("gradle-scripts/hilt.gradle"))
apply(from = project.rootProject.file("gradle-scripts/serialization.gradle"))
apply(from = project.rootProject.file("gradle-scripts/navigation.gradle"))

android {
    namespace = "com.dkin.chevit.presentation.home"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":presentation:resource"))
    implementation(project(":presentation:deeplink"))
    implementation(project(":presentation:common"))
    implementation(libs.compose.navigation)
    implementation(libs.coil.compose)
    implementation(libs.lottie.compose)
}
