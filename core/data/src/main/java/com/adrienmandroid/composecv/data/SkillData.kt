package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Skill


interface SkillData {
    fun getSkills(): List<Skill>
}