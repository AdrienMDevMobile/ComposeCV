package com.adrienmandroid.composecv.feature.skills.data.converter

import com.adrienmandroid.composecv.feature.skills.data.SkillData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.model.SubSkills

fun SkillData.toDomain() = Skill(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkills = if(subSkill_one != null && subSkill_two != null) SubSkills(
        first = subSkill_one,
        second = subSkill_two
    ) else null,
    explanation = explanation
)

fun Skill.toData() = SkillData(
    uid = uid,
    name = name,
    targetValue = targetValue,
    subSkill_one = subSkills?.first,
    subSkill_two = subSkills?.second,
    explanation = explanation
)