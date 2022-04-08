package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.SkillData

class SkillDataImpl : SkillData {

    override fun getSkills(): List<Skill> = listOf(
        Skill("Super skill1", 0.6f, "Texte skill 1"),
        Skill("Super skill2", 1f, "Texte skill 2"),
        Skill("Super skill3", 0.7f, "Texte skill 3")
    )
}