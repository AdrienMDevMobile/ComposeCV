package com.adrienmandroid.composecv.feature.skills.data.local

import com.adrienmandroid.composecv.feature.skills.data.SkillLocalDataSource
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.data.converter.toLocalData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SkillLocalDataSourceRoomImpl @Inject constructor(
    private val skillDao: SkillDao,
) : SkillLocalDataSource {
    override fun saveData(data: BasicResponse<Skill>) {
        skillDao.insertAll(*data.page.map { it.toLocalData() }.toTypedArray())
    }

    override fun getData(): Flow<BasicResponse<Skill>> = skillDao.getAllAsFlow().map { skills ->
        skills.map { skill ->
            skill.toDomain()
        }.toResponse()
    }
}