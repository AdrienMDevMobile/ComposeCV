plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.welcome.ui"

}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:welcome:domain"))
    implementation(project(":core:test"))
}