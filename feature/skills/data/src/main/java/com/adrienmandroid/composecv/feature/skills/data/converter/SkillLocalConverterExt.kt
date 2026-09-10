package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.data.local.Skill as SkillLocal

fun SkillLocal.toDomain() = if (targetValue != null) {
    Skill.PercentageSkill(
        uid = uid,
        name = name,
        explanation = explanation,
        targetValue = targetValue,
    )
} else if (subSkillOne != null && subSkillTwo != null) {
    Skill.Subskills(
        uid = uid,
        name = name,
        explanation = explanation,
        subSkills = Pair(
            first = subSkillOne,
            second = subSkillTwo
        )
    )
} else null

fun Skill.toLocalData() = when (this) {
    is Skill.PercentageSkill -> SkillLocal(
        uid = uid,
        name = name,
        targetValue = targetValue,
        subSkillOne = null,
        subSkillTwo = null,
        explanation = explanation
    )

    is Skill.Subskills -> SkillLocal(
        uid = uid,
        name = name,
        targetValue = null,
        subSkillOne = subSkills.first,
        subSkillTwo = subSkills.second,
        explanation = explanation
    )
}