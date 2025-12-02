package com.adrienmandroid.composecv.feature.experience.data.remote

import com.adrienmandroid.composecv.feature.experience.data.ExperienceRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import retrofit2.Retrofit
import javax.inject.Inject

class ExperienceRemoteDataSourceApiImpl @Inject constructor(
    retrofit: Retrofit
) : ExperienceRemoteDataSource {
    private val experienceApi: ExperienceApi = retrofit.create(ExperienceApi::class.java)

    override suspend fun getData(): Response<Unit, Experience> =
        experienceApi.getExperiences().map { experience -> experience.toDomain() }.toResponse()
}