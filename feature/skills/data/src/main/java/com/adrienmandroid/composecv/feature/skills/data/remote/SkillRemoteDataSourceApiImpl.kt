package com.adrienmandroid.composecv.feature.skills.data.remote

import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteDataSource
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.data.remote.api.SkillApi
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import retrofit2.Retrofit
import javax.inject.Inject

class SkillRemoteDataSourceApiImpl @Inject constructor(
    retrofit: Retrofit
) : SkillRemoteDataSource {
    private val api: SkillApi = retrofit.create(SkillApi::class.java)

    override suspend fun getData(): Response<Unit, Skill> =
        api.getSkills().map { skill -> skill.toDomain() }.toResponse()
}