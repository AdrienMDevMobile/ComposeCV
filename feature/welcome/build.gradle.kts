plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.library.compose)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.welcome"

}

dependencies {
    implementation(project(":shared:ui"))
    implementation(project(":core:data"))
}