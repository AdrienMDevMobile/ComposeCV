package com.adrienmandroid.composecv.feature.skills.ui.state

import androidx.compose.ui.graphics.Color

data class SkillUiState(
    val name: String,
    val targetValue: Float? = null,
    val targetValueColor: Color = Color.Unspecified,
    val subSkills: Pair<String, String>? = null,
    val explanation: String
    )