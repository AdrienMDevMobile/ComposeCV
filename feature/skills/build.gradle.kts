plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.library.compose)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.skills"

}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
}