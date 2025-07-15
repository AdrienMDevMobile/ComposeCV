plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.skills.ui"

}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
}