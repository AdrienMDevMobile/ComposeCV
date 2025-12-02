package com.adrienmandroid.composecv.feature.skills.domain.repository

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.model.response.BasicResponse
import kotlinx.coroutines.flow.Flow

interface SkillRepository {
    fun get(): Flow<BasicResponse<Skill>>
}