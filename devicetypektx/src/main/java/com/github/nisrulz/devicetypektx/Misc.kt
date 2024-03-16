package com.github.nisrulz.devicetypektx

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

/**
 * Checks if the device is in multi-window mode.
 *
 * @return true if the device is in multi-window mode, false otherwise
 */
fun Activity.isMultiWindowModeActive(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInMultiWindowMode
}

/**
 * Checks if the device has a camera.
 *
 * @return true if the device has a camera, false otherwise
 */
fun Context.isCameraAvailable(): Boolean {
    return checkFeature(PackageManager.FEATURE_CAMERA_ANY)
}
