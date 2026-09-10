package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.data.remote.SkillRemoteBody as SkillRemote

fun SkillRemote.toDomain() = if (targetValue != null) {
    Skill.PercentageSkill(
        uid = 0,
        name = name,
        explanation = explanation,
        targetValue = targetValue,
    )
} else if (subSkills != null) {
    Skill.Subskills(
        uid = 0,
        name = name,
        explanation = explanation,
        subSkills = Pair(
            first = subSkills.first,
            second = subSkills.second
        )
    )
} else null