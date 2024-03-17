plugins {
    id("app-convention")
}

android {
    namespace = "com.github.nisrulz.devicetypektxproject"

    defaultConfig {
        versionCode = APP_VERSION_CODE
        versionName = APP_VERSION_NAME
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Modules
    // implementation(project(":devicetypektx"))

    // Maven
    val deviceTypeKtxVer = "1.0.1"
    implementation("com.github.nisrulz:devicetypektx:$deviceTypeKtxVer")
}
