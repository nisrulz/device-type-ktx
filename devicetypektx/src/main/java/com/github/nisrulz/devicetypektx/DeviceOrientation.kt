package com.github.nisrulz.devicetypektx

import android.app.Activity
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

/**
 * Checks if the device is in portrait orientation.
 */
fun Activity.isPortraitOrientation(): Boolean {
    return requestedOrientation == SCREEN_ORIENTATION_PORTRAIT
}

/**
 * Checks if the device is in landscape orientation.
 */
fun Activity.isLandscapeOrientation(): Boolean {
    return requestedOrientation == SCREEN_ORIENTATION_LANDSCAPE
}