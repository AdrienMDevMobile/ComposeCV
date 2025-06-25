plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.library.compose)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.ksp)
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.other"

    /*TODO
    buildFeatures {
        //Necessaire pour afficher le numéro de version dans l'app
        buildConfig(true)
    }*/
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    debugImplementation(project(":core:test"))

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
}