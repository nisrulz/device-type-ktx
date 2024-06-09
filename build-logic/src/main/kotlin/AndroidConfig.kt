object BuildSdkInfo {
    const val COMPILE_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 34
    const val JVM_TARGET = 8
}

object ApplicationInfo {
    const val APPLICATION_VERSION_NAME = "1.0"
    const val APPLICATION_VERSION_CODE = 1
}

object LibraryInfo {
    const val POM_VERSION = "1.0.2"
    const val POM_ARTIFACT_ID = "devicetypektx"
    const val POM_NAME = "Device Type KTX"
    const val POM_DESCRIPTION =
        "Android library to provide Kotlin extensions for working with specific device types."
    const val POM_INCEPTION_YEAR = "2024"

    private const val GITHUB_REPO_NAME = "device-type-ktx"
    const val POM_URL = "https://github.com/nisrulz/$GITHUB_REPO_NAME/"
    const val POM_SCM_URL = "https://github.com/nisrulz/$GITHUB_REPO_NAME/"
    const val POM_SCM_CONNECTION = "scm:git:git://github.com/nisrulz/$GITHUB_REPO_NAME.git"
    const val POM_SCM_DEV_CONNECTION = "scm:git:ssh://git@github.com/nisrulz/$GITHUB_REPO_NAME.git"
}
