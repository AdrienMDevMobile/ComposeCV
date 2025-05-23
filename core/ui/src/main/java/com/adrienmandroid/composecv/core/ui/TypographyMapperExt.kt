package com.adrienmandroid.composecv.core.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.adrienmandroid.composecv.model.TypographyEnum

@Composable
fun TypographyEnum.toMaterialTypography(): TextStyle {
    return when (this) {
        TypographyEnum.H1        -> MaterialTheme.typography.h1
        TypographyEnum.H2        -> MaterialTheme.typography.h2
        TypographyEnum.H3        -> MaterialTheme.typography.h3
        TypographyEnum.H4        -> MaterialTheme.typography.h4
        TypographyEnum.H5        -> MaterialTheme.typography.h5
        TypographyEnum.H6        -> MaterialTheme.typography.h6
        TypographyEnum.SUBTITLE1 -> MaterialTheme.typography.subtitle1
        TypographyEnum.SUBTITLE2 -> MaterialTheme.typography.subtitle2
        TypographyEnum.BODY1     -> MaterialTheme.typography.body1
        TypographyEnum.BODY2     -> MaterialTheme.typography.body2
        TypographyEnum.BUTTON    -> MaterialTheme.typography.button
        TypographyEnum.CAPTION   -> MaterialTheme.typography.caption
        TypographyEnum.OVERLINE  -> MaterialTheme.typography.overline
    }
}