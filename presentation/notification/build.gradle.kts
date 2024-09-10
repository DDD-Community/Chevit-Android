plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

apply(from = project.rootProject.file("gradle-scripts/base.gradle"))
apply(from = project.rootProject.file("gradle-scripts/hilt.gradle"))

android {
    namespace = "com.dkin.chevit.presentation.notification"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(libs.firebase.messaging.ktx)
    implementation(libs.androidx.lifecycle.process)
}
