// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

    alias(libs.plugins.android.library) apply false

    alias(libs.plugins.kotlin.android) apply false

    alias(libs.plugins.maven.publish) apply false

    alias(libs.plugins.dokka) apply false

    alias(libs.plugins.compose.compiler) apply false

    alias(libs.plugins.binary.compatibility.validator) apply false
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
