plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    compileSdk = BuildSdkInfo.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildSdkInfo.MIN_SDK_VERSION
        targetSdk = BuildSdkInfo.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildSdkInfo.COMPOSE_COMPILER_VERSION
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
    // Note: Setting a toolchain via the kotlin extension updates the toolchain for Java compile
    // tasks as well.
    kotlin {
        jvmToolchain(BuildSdkInfo.JVM_TARGET)
    }
}
