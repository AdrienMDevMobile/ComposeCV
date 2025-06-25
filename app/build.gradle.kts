plugins {
    alias(libs.plugins.convention.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)

    //TODO
    //alias(libs.plugins.convention.library.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hiltAndroid)
}

android {
    defaultConfig {
        applicationId = "com.adrienmandroid.composecv"
        versionCode = 12
        versionName = "1.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    /*
    flavorDimensions.add("application_owner")
    productFlavors {
        create("AdrienOwner") {
            dimension = "application_owner"
            applicationId = "com.adrienmandroid.adrrienowner"
        }
        create("JeromeOwner") {
            dimension = "application_owner"
            applicationId = "com.adrienmandroid.jeromeowner"
        }
    }
    sourceSets {
        getByName("AdrienOwner") {
            res.srcDirs("src/adrien/res")
        }
        getByName("JeromeOwner") {
            res.srcDirs("src/jerome/res")
        }
    }
    */

    namespace = "com.adrienmandroid.composecv"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:data"))
    implementation(project(":feature:welcome"))
    implementation(project(":feature:skills"))
    implementation(project(":feature:experience"))
    implementation(project(":feature:other"))

    //TODO
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}