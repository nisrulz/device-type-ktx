# Usage Documentation

## Add as dependency

DeviceTypeKTX is published to MavenCentral, so you can add it to your project inside module's `build.gradle.kts` file as shown below:

```kotlin
dependencies {
    implementation("com.github.nisrulz:devicetypektx:${latest_version}")
    //...other dependencies
}
```

where `latest_version` is the latest version available on MavenCentral : [![Maven Central](https://img.shields.io/maven-central/v/com.github.nisrulz/devicetypektx)](https://central.sonatype.com/search?q=com.github.nisrulz.devicetypektx)

[Read API docs here](https://nisrulz.com/device-type-ktx/)

## Usage

### Check if device is a Phone or a Tablet

Extension functions are available which return a boolean value indicating whether the device is a Phone or a Tablet.

- `isPhone()` - returns true if the device is a Phone
- `isTablet()` - returns true if the device is a Tablet

Example usage:

```kt
if (isPhone()) {
    // Device is a Phone
} else if (isTablet()) {
    // Device is a Tablet
}
```

### Lock Orientation

To lock your Activity to Portrait orientation for only phones, navigate to your Activity code and add the below code under `onCreate()` right after `super.onCreate()` method:

```kt
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lockToPortraitOrientation(phone = true)
        ...
}
```

Here, `phone` is a boolean value which indicates whether you want to lock your Activity to Portrait orientation for only phones or not. This means when the application is runninng on a Tablet device, the Activity will be not be locked to Portrait orientation.

If you want to lock your Activity to Portrait orientation for both phones and Tablets, you can add the below code under `onCreate()` right after `super.onCreate()` method:

```kt
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lockToPortraitOrientation(phone = true, tablet = true)
        ...
}
```

Here, `tablet` is a boolean value which indicates whether you want to lock your Activity to Portrait orientation for Tablet devices. Since in the above code both `phone` and `tablet` are set to `true`, the Activity will be locked to Portrait orientation for both phones and Tablets.

Likewise, the library has a similar function to lock Activity to Landscape orientation: `lockToLandscapeOrientation(phone = false, tablet = false)`.

### Check device's current set screen orientation

Extension function is available to check device's screen orientation:

- `isPortraitOrientation()` - returns `true` if screen orientation is portrait
- `isLandscapeOrientation()` - returns `true` if screen orientation is landscape

### Check hardware feature availablity

Extension function are available to check if the device has a specific hardware feature:

1. `isBluetoothAvailable()` - returns `true` if Bluetooth is available
2. `isTelephonyAvailable()` - returns `true` if Telephony is available
3. `isNfcAvailable()` - returns `true` if NFC is available
4. `isCameraAvailable()` - returns `true` if Camera is available

### Check if device has MultiWindow mode enabled

Extension function is available to check if the device has MultiWindow mode enabled

- `isMultiWindowModeActive()` - returns `true` if MultiWindow mode is active

### Check device's screen resolution

Extension function is available to check device's screen resolution:

- `getScreenResolution()` - returns `ScreenResolution` object with screen resolution

where `ScreenResolution` object has following properties:

1. `width` - width of the screen in pixels
2. `height` - height of the screen in pixels
