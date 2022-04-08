package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.data.Skill


interface SkillData {
    fun getSkills() : List<Skill>
}