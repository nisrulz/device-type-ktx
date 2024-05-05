plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

// https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
// Note: Setting a toolchain via the kotlin extension updates the toolchain for Java compile
// tasks as well.
kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.gradle)
    implementation(libs.kotlin.gradle.plugin)
}
