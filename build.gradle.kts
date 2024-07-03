// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Android
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false

    // Kotlin
    alias(libs.plugins.kotlin.android) apply false

    // Maven Publishing
    alias(libs.plugins.maven.publish) apply false

    // Dokka for Documentation
    alias(libs.plugins.dokka) apply false

    // Compose
    alias(libs.plugins.compose.compiler) apply false
}

//region Publishing Tasks
tasks.register("releaseToMavenLocal") {
    val moduleName = "devicetypektx"
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":$moduleName:assembleRelease",
                    ":$moduleName:publishToMavenLocal",
                    "--no-configuration-cache",
                )
        }
    }
}

tasks.register("releaseToMavenCentral") {
    val moduleName = "devicetypektx"
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":$moduleName:assembleRelease",
                    ":$moduleName:publishToMavenCentral",
                    "--no-configuration-cache",
                )
        }
    }
}
//endregion

//region Docs
tasks.register("assembleDocs") {
    val moduleName = "devicetypektx"
    doLast {
        exec {
            commandLine =
                listOf(
                    "./gradlew",
                    ":$moduleName:dokkaHtml",
                    "--no-configuration-cache",
                )
        }
    }
}
//endregion
