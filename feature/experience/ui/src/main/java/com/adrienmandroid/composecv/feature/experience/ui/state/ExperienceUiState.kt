package com.adrienmandroid.composecv.feature.experience.ui.state

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.adrienmandroid.composecv.core.ui.Difference
import java.util.Date

data class ExperienceUiState(
    val name: String,
    val employer: String? = null,
    val logoUrl: String,
    val dateBegin: Date,
    val dateEnd: Date?,
    val expDuration: Difference,
    val headerColor: Color,
    val headerElevation: Dp,
    val informations: List<String>
)