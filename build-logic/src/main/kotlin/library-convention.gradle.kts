plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = BuildSdkInfo.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildSdkInfo.MIN_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    compileOptions {
        sourceCompatibility = BuildSdkInfo.JAVA_COMPAT_VERSION
        targetCompatibility = BuildSdkInfo.JAVA_COMPAT_VERSION
    }
    kotlinOptions {
        jvmTarget = BuildSdkInfo.JAVA_COMPAT_VERSION.toString()
    }
}
