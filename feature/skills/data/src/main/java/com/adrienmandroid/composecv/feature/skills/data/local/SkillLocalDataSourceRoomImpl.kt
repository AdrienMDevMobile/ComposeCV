package com.adrienmandroid.composecv.feature.skills.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.adrienmandroid.composecv.feature.skills.data.converter.toLocalData
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.data.SkillLocalDataSource
import javax.inject.Inject
import kotlin.collections.map
import kotlin.collections.toTypedArray

class SkillLocalDataSourceRoomImpl @Inject constructor (
    private val skillDao: SkillDao,
): SkillLocalDataSource {
    override fun saveData(data: List<Skill>) {
        skillDao.insertAll(*data.map { it.toLocalData() }.toTypedArray())
    }

    override fun getData(): LiveData<List<Skill>> = skillDao.getAll().map { skills ->
        skills.map { skill -> skill.toDomain() }
    }
}