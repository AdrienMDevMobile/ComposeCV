package com.adrienmandroid.composecv.feature.experience.data.local

import com.adrienmandroid.composecv.feature.experience.data.ExperienceLocalDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExperienceLocalDataSourceRoomImpl @Inject constructor (
    private val experienceDao: ExperienceDao,
): ExperienceLocalDataSource {
    override fun saveData(data: List<Experience>) {
        experienceDao.insertAll(*data.toTypedArray())
    }

    override fun getData(): Flow<List<Experience>> = experienceDao.getExperiencesAndInformationsAsFlow().map { experiences ->
        experiences.map { experience -> experience.toDomain() }
    }
}