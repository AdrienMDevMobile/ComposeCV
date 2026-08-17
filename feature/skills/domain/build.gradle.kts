plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.skills.domain"
}

dependencies {
    implementation(project(":core:model"))
}