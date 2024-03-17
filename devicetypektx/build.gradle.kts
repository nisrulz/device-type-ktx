import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    // Maven Publishing Plugin
    alias(libs.plugins.mavenPublishing)

    // Dokka
    id("org.jetbrains.dokka")
}

android {
    namespace = "com.github.nisrulz.devicetypektx"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //-------- Dokka
    //- Allows using @hide in code comments
    implementation("org.jetbrains.dokka:android-documentation-plugin:1.9.20")
    //- Versioning in API docs
    dokkaHtmlPlugin("org.jetbrains.dokka:versioning-plugin:1.9.20")
}

//region Dokka Configurations

// Library Version
val currentVersion = "1.0.0"
val isOldVersion = false
val versionOrdering = listOf(currentVersion)

// Dokka output directory
var dokkaOutputDir = "$rootDir/docs"
val previousVersionsDirectory =
    project.rootProject.projectDir.resolve("docs").invariantSeparatorsPath
val versioningConfiguration = """
    {
      "version": "$currentVersion",
      "versionsOrdering": ${versionOrdering.map { "\"$it\"" }.toTypedArray().contentToString()},
      "olderVersionsDir": "$previousVersionsDirectory",
      "renderVersionsNavigationOnAllPages": true
    }
    """

if (isOldVersion) {
    dokkaOutputDir = "$rootDir/docs/$currentVersion"
}


// Configure all single-project Dokka tasks at the same time,
// such as dokkaHtml, dokkaJavadoc and dokkaGfm.
tasks.withType<DokkaTask>().configureEach {
    // Set module name displayed in the final output
    moduleName.set("Device Type KTX")

    // Suppress obvious functions like default toString or equals. Defaults to true
    suppressObviousFunctions.set(false)

    // Suppress all inherited members that were not overridden in a given class.
    // Eg. using it you can suppress toString or equals functions but you can't suppress componentN or copy on data class. To do that use with suppressObviousFunctions
    // Defaults to false
    suppressInheritedMembers.set(true)

    dokkaSourceSets.configureEach {

        outputDirectory.set(file(dokkaOutputDir))

        pluginsMapConfiguration.set(

            mapOf(
                "org.jetbrains.dokka.versioning.VersioningPlugin" to versioningConfiguration
            )
        )

        // Do not create index pages for empty packages
        skipEmptyPackages.set(true)

        // Used for linking to JDK documentation
        jdkVersion.set(8)

        documentedVisibilities.set(
            setOf(
                DokkaConfiguration.Visibility.PUBLIC,
                DokkaConfiguration.Visibility.PROTECTED,
            )
        )

        perPackageOption {
            matchingRegex.set(".*internal.*")
            suppress.set(true)
        }
    }
}

tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("html-docs")
}

tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}
//endregion