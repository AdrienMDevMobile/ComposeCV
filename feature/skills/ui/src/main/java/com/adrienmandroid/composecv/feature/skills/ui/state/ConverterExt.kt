package com.adrienmandroid.composecv.feature.skills.ui.state

import androidx.compose.ui.graphics.Color
import com.adrienmandroid.composecv.core.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.core.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.core.ui.theme.colorSkillMedium
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

fun Skill.toUiState() = SkillUiState(
    name = name,
    targetValue = targetValue,
    targetValueColor = targetValue?.getSkillColor() ?: Color.Unspecified,
    subSkills = subSkills,
    explanation = explanation
)

fun Float.getSkillColor() = when {
    this >= 0.8f -> colorSkillHigh
    this >= 0.6f -> colorSkillMedium
    else -> colorSkillLow
}