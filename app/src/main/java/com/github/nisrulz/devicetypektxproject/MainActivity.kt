package com.github.nisrulz.devicetypektxproject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.nisrulz.devicetypektx.isLandscapeOrientation
import com.github.nisrulz.devicetypektx.isPhone
import com.github.nisrulz.devicetypektx.isPortraitOrientation
import com.github.nisrulz.devicetypektx.isTablet
import com.github.nisrulz.devicetypektx.lockToPortraitOrientation
import com.github.nisrulz.devicetypektxproject.ui.theme.DeviceTypeKTXProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lockToPortraitOrientation(phone = true)

        setContent {
            DeviceTypeKTXProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val txtToShow = prepareStringToShow()
                    MainScreen(txtToShow)
                }
            }
        }
    }
}

private fun Activity.prepareStringToShow(): String {
    val txtToShow = StringBuilder().append("Device Type = ")

    if (isPhone()) {
        txtToShow.append("Phone")
    } else if (isTablet()) {
        txtToShow.append("Tablet")
    }

    txtToShow
        .append("\n")
        .append("Orientation Set = ")

    if (isPortraitOrientation()) {
        txtToShow.append("Portrait")
    } else if (isLandscapeOrientation()) {
        txtToShow.append("Landscape")
    } else {
        txtToShow.append("No")
    }
    return txtToShow.toString()
}

@Composable
fun MainScreen(text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DeviceTypeKTXProjectTheme {
        MainScreen("Hello World")
    }
}