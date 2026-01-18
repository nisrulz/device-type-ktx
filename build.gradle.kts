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


abstract class GradleExecTask @Inject constructor(
    private val execOps: ExecOperations
) : DefaultTask() {

    lateinit var moduleName: String
    lateinit var gradleTask: String

    @TaskAction
    fun run() {
        execOps.exec {
            commandLine(
                "./gradlew",
                ":$moduleName:$gradleTask",
                "--no-configuration-cache"
            )
        }
    }
}


//region Publishing Tasks
tasks.register<GradleExecTask>("releaseToMavenLocal") {
    moduleName = "devicetypektx"
    gradleTask = "publishToMavenLocal"
}
tasks.register<GradleExecTask>("releaseToMavenCentral") {
    moduleName = "devicetypektx"
    gradleTask = "publishToMavenCentral"
}
//endregion

//region Docs
tasks.register<GradleExecTask>("assembleDocs") {
    moduleName = "devicetypektx"
    gradleTask = "dokkaHtml"
}

//endregion
