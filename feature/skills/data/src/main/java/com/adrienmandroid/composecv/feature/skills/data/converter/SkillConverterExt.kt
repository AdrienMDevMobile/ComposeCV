package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.data.SkillData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.model.SubSkills

fun SkillData.toDomain() = Skill(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkills = if(subSkillOne != null && subSkillTwo != null) SubSkills(
        first = subSkillOne,
        second = subSkillTwo
    ) else null,
    explanation = explanation
)

fun Skill.toData() = SkillData(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkillOne = subSkills?.first,
    subSkillTwo = subSkills?.second,
    explanation = explanation
)