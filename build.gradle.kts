// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.androidLibrary) apply false

    // Maven Publishing Plugin
    alias(libs.plugins.mavenPublishing) apply false

    // Dokka
    alias(libs.plugins.dokka) apply false

    // Compose
    alias(libs.plugins.compose.compiler) apply false
}

//region Publishing Tasks
tasks.register("releaseToMavenLocal") {
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":devicetypektx:assembleRelease",
                    ":devicetypektx:publishToMavenLocal",
                    "--no-configuration-cache",
                )
        }
    }
}

tasks.register("releaseToMavenCentral") {
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":devicetypektx:assembleRelease",
                    ":devicetypektx:publishToMavenCentral",
                    "--no-configuration-cache",
                )
        }
    }
}
//endregion

//region Docs
tasks.register("assembleDocs") {
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":devicetypektx:dokkaHtml",
                    "--quiet",
                    "--no-configuration-cache",
                )
        }
    }
}
//endregion
