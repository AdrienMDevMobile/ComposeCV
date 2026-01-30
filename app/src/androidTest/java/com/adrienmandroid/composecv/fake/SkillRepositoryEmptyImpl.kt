package com.adrienmandroid.composecv.fake

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SkillRepositoryEmptyImpl @Inject constructor() : SkillRepository {
    override fun get(): Flow<BasicResponse<Skill>> = flow {
        emit(emptyList<Skill>().toResponse())
    }
}