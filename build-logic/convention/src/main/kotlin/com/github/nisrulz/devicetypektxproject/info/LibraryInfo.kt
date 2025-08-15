package com.github.nisrulz.devicetypektxproject.info

object LibraryInfo {
    const val POM_VERSION = "1.0.3"
    const val POM_ARTIFACT_ID = "devicetypektx"
    const val POM_NAME = "Device Type KTX"
    const val POM_DESCRIPTION =
        "Android library to provide Kotlin extensions for working with specific device types."
    const val POM_INCEPTION_YEAR = "2024"

    private const val GITHUB_REPO_NAME = "device-type-ktx"
    private const val GITHUB_USER = "github.com/nisrulz"
    const val POM_URL = "https://$GITHUB_USER/$GITHUB_REPO_NAME/"
    const val POM_SCM_URL = "https://$GITHUB_USER/$GITHUB_REPO_NAME/"
    const val POM_SCM_CONNECTION = "scm:git:git://$GITHUB_USER/$GITHUB_REPO_NAME.git"
    const val POM_SCM_DEV_CONNECTION = "scm:git:ssh://git@$GITHUB_USER/$GITHUB_REPO_NAME.git"
}
