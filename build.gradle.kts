plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.operit.ui.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.operit.ui.sample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.foundation:foundation:1.6.0")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}