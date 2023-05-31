plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "dev.yjyoon.goorle"
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.yjyoon.goorle"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
        vectorDrawables {
            useSupportLibrary = true
        }

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
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi"
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/INDEX.LIST"
        }
    }
}

dependencies {

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.viewmodel.ktx)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.compose.ui.core)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material.iconscore)
    implementation(libs.compose.material3)

    implementation(libs.accompanist.webview)
    implementation(libs.accompanist.navigation)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.logging)
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.gson)

    implementation(libs.coil.compose)
    implementation(libs.image.cropper)
    
    implementation(libs.google.hilt.android)
    kapt(libs.google.hilt.compiler)

    debugImplementation(libs.compose.ui.tooling)

    coreLibraryDesugaring(libs.android.tools.desugar)
}
