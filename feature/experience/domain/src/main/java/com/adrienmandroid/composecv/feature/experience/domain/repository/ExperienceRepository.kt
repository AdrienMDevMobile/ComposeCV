package com.adrienmandroid.composecv.feature.experience.domain.repository

import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.model.response.BasicResponse
import kotlinx.coroutines.flow.Flow

interface ExperienceRepository {
    fun get(): Flow<BasicResponse<Experience>>
}