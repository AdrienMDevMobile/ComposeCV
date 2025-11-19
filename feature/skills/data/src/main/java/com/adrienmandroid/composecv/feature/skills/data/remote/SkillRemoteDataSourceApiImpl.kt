package com.adrienmandroid.composecv.feature.skills.data.remote

import com.adrienmandroid.composecv.data.remote.RetrofitInstance
import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteDataSource
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.data.remote.api.SkillApi
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import javax.inject.Inject

class SkillRemoteDataSourceApiImpl @Inject constructor() : SkillRemoteDataSource {
    val api: SkillApi = RetrofitInstance.retrofit.create(SkillApi::class.java)

    override suspend fun getData(): Response<Unit, Skill> =
        api.getSkills().map { skill -> skill.toDomain() }.toResponse()
}