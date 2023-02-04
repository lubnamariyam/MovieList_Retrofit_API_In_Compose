package com.lubnamariyam.retrofitapiinjetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0x212121),
    primaryVariant = Color(0x3700B3),
    secondary = Color(0x03DAC6),
    background = Color(0x121212),
    surface = Color(0x424242),
    error = Color(0xB00020)
)

private val LightColorPalette = lightColors(
    primary = Color(0xBB86FC),
    primaryVariant = Color(0x3700B3),
    secondary = Color(0x03DAC6),
    background = Color(0xF0F0F0),
    surface = Color(0xFFFFFF),
    error = Color(0xB00020)
)

@Composable
fun RetrofitAPIInJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}