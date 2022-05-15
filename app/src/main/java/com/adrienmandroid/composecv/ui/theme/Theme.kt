package com.adrienmandroid.composecv.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColors(
    primary = shadowBrown,
    primaryVariant = lightBrown,
    secondary = Teal200,
    surface = veryLightBrown,
)

private val LightColorPalette = lightColors(
    primary = shadowBrown,
    primaryVariant = lightBrown,
    secondary = Teal200,
    surface = veryLightBrown,
)

@Composable
fun ComposeCVTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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

val Colors.border: Color
    get() = if (isLight) shadowBrown else shadowBrown

val Colors.composableBackground: Color
    get() = if (isLight) lightGray else lightGray

val Colors.onSurfaceTitle: Color
    get() = if (isLight) white else white