package com.adrienmandroid.composecv.feature.skills.ui.state

import androidx.compose.ui.graphics.Color

sealed class SkillUiState(val name: String, val explanation: String) {
    class PercentageSkillUiState(
        name: String,
        explanation: String,
        val percentString: String,
        val targetValue: Float,
        val targetValueColor: Color
    ) : SkillUiState(name, explanation)

    class SubskillsUiState(
        name: String,
        explanation: String,
        val subSkills: Pair<String, String>
    ) : SkillUiState(name, explanation)
}