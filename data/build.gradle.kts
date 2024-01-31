@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

apply(from = project.rootProject.file("gradle-scripts/base.gradle"))
apply(from = project.rootProject.file("gradle-scripts/serialization.gradle"))
apply(from = project.rootProject.file("gradle-scripts/hilt.gradle"))
apply(from = project.rootProject.file("gradle-scripts/protobuf.gradle"))

android {
    namespace = "com.dkin.chevit.data"
    defaultConfig {
        buildConfigField("String", "API_URL", "\"https://jrq7w2orw3.execute-api.ap-northeast-2.amazonaws.com\"")
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.bundles.okhttp)
    debugImplementation(libs.bundles.okhttp.debug)
    implementation(libs.bundles.retrofit)
    debugImplementation(libs.chucker.debug)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.crashlytics)
}
