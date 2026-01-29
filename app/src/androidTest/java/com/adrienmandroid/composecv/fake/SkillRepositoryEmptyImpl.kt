package com.adrienmandroid.composecv.fake

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.model.response.BasicResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SkillRepositoryEmptyImpl : SkillRepository {
    override fun get(): Flow<BasicResponse<Skill>> = flow {
    }
}