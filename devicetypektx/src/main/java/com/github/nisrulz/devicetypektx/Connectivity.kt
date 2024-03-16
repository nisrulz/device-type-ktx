package com.github.nisrulz.devicetypektx

import android.content.Context
import android.content.pm.PackageManager

/**
 * Checks if the device has a Telephony capability.
 *
 * @return true if the device has a Telephony capability, false otherwise
 */
fun Context.isTelephonyAvailable(): Boolean {
    return checkFeature(PackageManager.FEATURE_TELEPHONY)
}

/**
 * Checks if the device has a bluetooth.
 *
 * @return true if the device has a bluetooth, false otherwise
 */
fun Context.isBluetoothAvailable(): Boolean {
    return checkFeature(PackageManager.FEATURE_BLUETOOTH)
}

/**
 * Checks if the device has a NFC.
 *
 * @return true if the device has a NFC, false otherwise
 */
fun Context.isNfcAvailable(): Boolean {
    return checkFeature(PackageManager.FEATURE_NFC)
}

/**
 * Checks if the device has a feature.
 *
 * @param feature the feature to check for
 * @return true if the device has the feature, false otherwise
 */
internal fun Context.checkFeature(feature: String): Boolean {
    return packageManager.hasSystemFeature(feature)
}