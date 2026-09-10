package com.adrienmandroid.composecv.feature.skills.ui.state

import com.adrienmandroid.composecv.core.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.core.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.core.ui.theme.colorSkillMedium
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

fun Skill.toUiState() = when(this){
    is Skill.PercentageSkill -> SkillUiState.PercentageSkillUiState(
        name = name,
        percentString = targetValue.toPercentString(),
        targetValue = targetValue,
        targetValueColor = targetValue.getSkillColor(),
        explanation = explanation
    )
    is Skill.Subskills -> SkillUiState.SubskillsUiState(
        name = name,
        subSkills = subSkills,
        explanation = explanation
    )
}

private fun Float.toPercentString() = (this * 100).toInt().toString() + "%"

fun Float.getSkillColor() = when {
    this >= 0.8f -> colorSkillHigh
    this >= 0.6f -> colorSkillMedium
    else -> colorSkillLow
}