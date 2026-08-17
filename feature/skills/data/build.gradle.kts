plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
    alias(libs.plugins.convention.retrofit.api.library)
    alias(libs.plugins.convention.room.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.skills.data"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":feature:skills:domain"))
}