package com.adrienmandroid.composecv.core.ui.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val roundedTopEndSquare =
    RoundedCornerShape(CornerSize(0), CornerSize(100), CornerSize(0), CornerSize(0))