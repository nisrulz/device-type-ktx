package com.github.nisrulz.devicetypektx

import android.content.Context


/**
 * Check if the device is a phone (small screen)
 */
fun Context.isPhone(): Boolean {
    return resources.getBoolean(R.bool.isPhone)
}

/**
 * Check if the device is a tablet (large screen)
 */
fun Context.isTablet(): Boolean {
    return resources.getBoolean(R.bool.isTablet)
}