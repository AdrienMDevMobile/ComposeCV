plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.other.data"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:other:domain"))
    debugImplementation(project(":core:test"))
}