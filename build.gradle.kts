// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false

    // Maven Publishing Plugin
    alias(libs.plugins.mavenPublishing) apply false
}

//region Publishing Tasks
tasks.register("publishToMavenLocal") {
    doLast {
        exec {
            commandLine = listOf(
                "./gradlew",
                ":devicetypektx:assembleRelease",
                ":devicetypektx:publishToMavenLocal",
                "--no-configuration-cache"
            )
        }
    }
}

tasks.register("publishToMavenCentral") {
    doLast {
        exec {
            commandLine = listOf(
                "./gradlew",
                ":devicetypektx:assembleRelease",
                ":devicetypektx:publishAllPublicationsToMavenCentral",
                "--no-configuration-cache"
            )
        }
    }
}
//endregion
