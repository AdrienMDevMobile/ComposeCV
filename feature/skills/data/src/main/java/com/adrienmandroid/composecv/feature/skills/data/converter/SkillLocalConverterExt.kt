package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.data.local.Skill as SkillLocal
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

fun SkillLocal.toDomain() = Skill(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkills = if(subSkillOne != null && subSkillTwo != null) Pair(
        first = subSkillOne,
        second = subSkillTwo
    ) else null,
    explanation = explanation
)

fun Skill.toLocalData() = SkillLocal(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkillOne = subSkills?.first,
    subSkillTwo = subSkills?.second,
    explanation = explanation
)