package com.adrienmandroid.composecv.feature.skills.domain.repository

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

interface SkillRemoteRepository {
    fun getSkills(): List<Skill>
}