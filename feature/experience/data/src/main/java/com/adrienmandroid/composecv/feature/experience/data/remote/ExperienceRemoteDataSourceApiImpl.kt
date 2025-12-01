package com.adrienmandroid.composecv.feature.experience.data.remote

import com.adrienmandroid.composecv.data.remote.RetrofitInstance
import com.adrienmandroid.composecv.feature.experience.data.ExperienceRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import javax.inject.Inject

class ExperienceRemoteDataSourceApiImpl @Inject constructor(): ExperienceRemoteDataSource {
    val experienceApi : ExperienceApi = TODO() //RetrofitInstance.retrofit.create(ExperienceApi::class.java)

    override suspend fun getData(): Response<Unit, Experience> =
        experienceApi.getExperiences().map { experience -> experience.toDomain() }.toResponse()
}