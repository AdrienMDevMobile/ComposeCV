package com.adrienmandroid.composecv.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White

val DarkColorPalette = darkColors(
    primary = colorDarkerGreen,
    primaryVariant = colorDarkestGreen,
    secondary = colorFlashiestGreen,
    secondaryVariant = colorDarkestGreen,
    surface = colorDarkestGreen,
)

private val LightColorPalette = lightColors(
    primary = colorLighterGreen,
    primaryVariant = colorEvenGreen,
    secondary = colorFlashiestGreen,
    secondaryVariant = colorDarkestGreen,
    surface = colorLighterGreen,
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
        shapes = Shapes,
        content = content
    )
}

val Colors.border: Color
    get() = if (isLight) colorDarkestGreen else colorLighterGreen

val Colors.onSurfaceTitle: Color
    get() = if (isLight) Black else White

val Colors.quoteBackground: Color
    get() = if (isLight) Black else DarkGray

val Colors.onQuoteBackground: Color
    get() = White

val Colors.carouselButton: Color
    get() = if (isLight) colorFlashiestGreen else colorDarkestGreen