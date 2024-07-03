package com.github.nisrulz.devicetypektxproject

import com.github.nisrulz.devicetypektxproject.ktx.configureAndroidApp
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            configureAndroidApp()
        }
    }
}
