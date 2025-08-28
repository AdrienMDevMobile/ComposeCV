package com.adrienmandroid.composecv.feature.skills.domain.repository

import androidx.lifecycle.LiveData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

interface SkillLocalRepository {
    fun saveSkills(skills: List<Skill>)

    fun getSkills(): LiveData<List<Skill>>
}