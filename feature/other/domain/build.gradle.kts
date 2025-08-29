plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.other.domain"
}

dependencies {
    implementation(project(":core:model"))
}