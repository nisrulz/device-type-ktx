package com.github.nisrulz.devicetypektxproject

import com.github.nisrulz.devicetypektxproject.ktx.configureAndroidLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            configureAndroidLibrary()
        }
    }
}
