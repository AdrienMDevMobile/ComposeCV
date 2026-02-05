plugins {
    alias(libs.plugins.convention.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.convention.retrofit.core.library)
}

android {
    defaultConfig {
        applicationId = "com.adrienmandroid.composecv"
        versionCode = 12
        versionName = "1.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //signingConfig = signingConfigs.getByName("debug")
    }


    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true

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
    implementation(project(":feature:experience:data"))
    implementation(project(":feature:experience:domain"))
    implementation(project(":feature:experience:ui"))
    implementation(project(":feature:welcome:data"))
    implementation(project(":feature:welcome:domain"))
    implementation(project(":feature:welcome:ui"))
    implementation(project(":feature:skills:data"))
    implementation(project(":feature:skills:domain"))
    implementation(project(":feature:skills:ui"))
    implementation(project(":feature:other:data"))
    implementation(project(":feature:other:domain"))
    implementation(project(":feature:other:ui"))
}