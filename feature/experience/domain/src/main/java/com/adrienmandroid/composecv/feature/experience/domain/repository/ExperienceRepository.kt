package com.adrienmandroid.composecv.feature.experience.domain.repository

import androidx.lifecycle.LiveData
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import kotlinx.coroutines.CoroutineScope

interface ExperienceRepository {
    fun get(coroutineScope: CoroutineScope): LiveData<List<Experience>>
}