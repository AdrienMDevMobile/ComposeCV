package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.data.remote.Skill as SkillRemote
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

fun SkillRemote.toDomain() = Skill(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkills = if(subSkills != null) Pair(
        first = subSkills.first,
        second = subSkills.second
    ) else null,
    explanation = explanation
)