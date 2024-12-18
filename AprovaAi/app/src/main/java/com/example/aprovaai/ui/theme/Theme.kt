package com.example.aprovaai.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Esquema de cores claras
private val LightColors = lightColorScheme(
    primary = BlueBase,
    onPrimary = Color.White,
    secondary = RedHighlight,
    onSecondary = Color.White,
    background = BlueLight,
    onBackground = GrayDark,
    surface = GrayLight,
    onSurface = GrayDark,
    error = RedHighlight,
    onError = Color.White,
)

// Esquema de cores escuras
private val DarkColors = darkColorScheme(
    primary = BlueDark,
    onPrimary = Color.Black,
    secondary = RedHighlight,
    onSecondary = Color.Black,
    background = GrayDark,
    onBackground = GrayLight,
    surface = GrayDark,
    onSurface = GrayLight,
    error = RedHighlight,
    onError = Color.Black,
)

@Composable
fun AprovaAiTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
