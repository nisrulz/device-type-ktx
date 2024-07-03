import com.github.nisrulz.devicetypektxproject.info.LibraryInfo
import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.devicetypektxproject.android.library)

    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
}

android {
    namespace = "com.github.nisrulz." + LibraryInfo.POM_ARTIFACT_ID
}

//region Maven Publishing
mavenPublishing {
    coordinates(artifactId = LibraryInfo.POM_ARTIFACT_ID, version = LibraryInfo.POM_VERSION)

    pom {
        name.set(LibraryInfo.POM_NAME)
        description.set(LibraryInfo.POM_DESCRIPTION)
        inceptionYear.set(LibraryInfo.POM_INCEPTION_YEAR)
        url.set(LibraryInfo.POM_URL)
        scm {
            url.set(LibraryInfo.POM_SCM_URL)
            connection.set(LibraryInfo.POM_SCM_CONNECTION)
            developerConnection.set(LibraryInfo.POM_SCM_DEV_CONNECTION)
        }
    }
}

//endregion

//region Dokka Configurations

dependencies {
    // -------- Dokka
    // - Allows using @hide in code comments
    dokkaHtmlPlugin(libs.dokka.android)
    // - Versioning in API docs
    dokkaHtmlPlugin(libs.dokka.versioning)
}

// Library Version
val currentVersion = LibraryInfo.POM_VERSION

/*
 How to Use
 __________
 When generating for the very first version i.e 1.0.0, set isOldVersion = false
   - Generate the docs by running ./gradlew assembleDocs
   - You will find the docs generated at the rootDir/docs

 When generating for the subsequent versions i.e 1.0.1, 1.1.0, 2.0.0, etc
    - First you need to preserve the old version docs, so keep the current version at what it
     was i.e 1.0.0
    - Set isOldVersion = true
    - Generate the docs by running ./gradlew assembleDocs
    - You will find the docs generated at the rootDir/docs/version i.e rootDir/docs/1.0.0
    - Now change the current version to 1.0.1
    - Set isOldVersion = false
    - Generate the docs by running ./gradlew assembleDocs
    - You will find the docs generated overwrite the last version with the new version 1.0.1
       at the rootDir/docs with navigation for the older version 1.0.0 (picked from 1.0.0 dir
       automatically while maintaining the order as specified in versionOrdering below)
 */
val isOldVersion = false

/*
 * Update this with older versions as new one is ready to be released. This maintains the order of
 * versions in the drop down. The first item is the one highlighted and selected on opening the
 * home page.
 *
 * Example:
 * val currentVersion = "1.2.0"
 * val versionOrdering = listOf(currentVersion, "1.1.0", "1.0.0")
 */
val versionOrdering = listOf(currentVersion)

// Dokka output directory
var dokkaOutputDir = "$rootDir/docs"
val previousVersionsDirectory =
    project.rootProject.projectDir
        .resolve("docs")
        .invariantSeparatorsPath
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
    moduleName.set(LibraryInfo.POM_NAME)

    // Suppress obvious functions like default toString or equals. Defaults to true
    suppressObviousFunctions.set(false)

    // Suppress all inherited members that were not overridden in a given class.
    suppressInheritedMembers.set(true)

    dokkaSourceSets.configureEach {
        // Output directory
        outputDirectory.set(file(dokkaOutputDir))

        // Versioning Plugin
        pluginsMapConfiguration.set(
            mapOf(
                "org.jetbrains.dokka.versioning.VersioningPlugin" to versioningConfiguration,
            ),
        )

        // Do not create index pages for empty packages
        skipEmptyPackages.set(true)

        // Used for linking to JDK documentation
        jdkVersion.set(8)

        // Only include public and protected members of the package
        documentedVisibilities.set(
            setOf(
                DokkaConfiguration.Visibility.PUBLIC,
                DokkaConfiguration.Visibility.PROTECTED,
            ),
        )

        // Exclude internal packages
        perPackageOption {
            matchingRegex.set(".*internal.*")
            suppress.set(true)
        }
    }
}

//endregion
