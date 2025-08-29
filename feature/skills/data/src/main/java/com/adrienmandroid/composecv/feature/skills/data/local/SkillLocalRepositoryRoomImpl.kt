package com.adrienmandroid.composecv.feature.skills.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.adrienmandroid.composecv.feature.skills.data.converter.toLocalData
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillLocalRepository
import javax.inject.Inject

class SkillLocalRepositoryRoomImpl @Inject constructor (
    private val skillDao: SkillDao,
): SkillLocalRepository {
    override fun saveSkills(skills: List<Skill>) {
        skillDao.insertAll(*skills.map { it.toLocalData() }.toTypedArray())
    }

    override fun getSkills(): LiveData<List<Skill>> = skillDao.getAll().map { skills ->
        skills.map { skill -> skill.toDomain() }
    }
}