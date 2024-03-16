package com.github.nisrulz.devicetypektx

import android.content.Context

/**
 * Gets the screen resolution.
 *
 * @return the screen resolution as a pair of width and height
 */
fun Context.getScreenResolution(): ScreenResolution {
    val displayMetrics = resources.displayMetrics
    return ScreenResolution(displayMetrics.widthPixels, displayMetrics.heightPixels)
}

/**
 * Data class representing the screen resolution.
 *
 * @property width the width of the screen in pixels
 * @property height the height of the screen in pixels
 */
data class ScreenResolution(val width: Int, val height: Int)