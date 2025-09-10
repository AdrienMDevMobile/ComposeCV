package com.adrienmandroid.composecv.feature.experience.domain.repository

import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface ExperienceRepository {
    fun get(coroutineScope: CoroutineScope): Flow<List<Experience>>
}