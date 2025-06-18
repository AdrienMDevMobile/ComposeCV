package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Skill


interface SkillRepository {
    fun getSkills(): List<Skill>
}