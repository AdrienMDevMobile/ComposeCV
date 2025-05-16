package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.model.Skill


interface SkillData {
    fun getSkills(): List<Skill>
}