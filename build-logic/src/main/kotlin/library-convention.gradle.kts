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

    // https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
    // Note: Setting a toolchain via the kotlin extension updates the toolchain for Java compile
    // tasks as well.
    kotlin {
        jvmToolchain(BuildSdkInfo.JVM_TARGET)
    }
}
