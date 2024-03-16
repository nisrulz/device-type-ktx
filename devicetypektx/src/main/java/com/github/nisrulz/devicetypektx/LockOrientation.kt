package com.github.nisrulz.devicetypektx

import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

/**
 * Lock the activity to portrait orientation on a phone, tablet or desktop.
 *
 * @param phone Specifies if the activity should be locked to portrait orientation on a phone
 * @param tablet Specifies if the activity should be locked to portrait orientation on a tablet
 */
@SuppressLint("SourceLockedOrientationActivity")
fun Activity.lockToPortraitOrientation(
    phone: Boolean = false, tablet: Boolean = false
) {
    lockToOrientation(SCREEN_ORIENTATION_PORTRAIT, phone, tablet)
}

/**
 * Lock the activity to landscape orientation on a phone, tablet or desktop
 * @param phone Specifies if the activity should be locked to landscape orientation on a phone
 * @param tablet Specifies if the activity should be locked to landscape orientation on a tablet
 */
fun Activity.lockToLandscapeOrientation(
    phone: Boolean = false, tablet: Boolean = false
) {
    lockToOrientation(SCREEN_ORIENTATION_LANDSCAPE, phone, tablet)
}

/**
 * Lock the activity to the specified orientation on a phone, tablet or desktop
 * @param type The orientation to lock to
 * @param phone Specifies if the activity should be locked to the specified orientation on a phone
 * @param tablet Specifies if the activity should be locked to the specified orientation on a tablet
 */
fun Activity.lockToOrientation(type: Int, phone: Boolean = false, tablet: Boolean = false) {
    val enableOnPhone = phone && isPhone()
    val enableOnTablet = tablet && isTablet()

    if (enableOnPhone || enableOnTablet) {
        setOrientation(type)
    }
}

/**
 * Set the orientation of the activity
 * @param type The orientation to set to
 */
fun Activity.setOrientation(type: Int = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
    requestedOrientation = type
}