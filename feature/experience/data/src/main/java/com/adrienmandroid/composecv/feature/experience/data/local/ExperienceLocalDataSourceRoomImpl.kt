package com.adrienmandroid.composecv.feature.experience.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.adrienmandroid.composecv.feature.experience.data.ExperienceLocalDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import javax.inject.Inject

class ExperienceLocalDataSourceRoomImpl @Inject constructor (
    private val experienceDao: ExperienceDao,
): ExperienceLocalDataSource {
    override fun saveData(data: List<Experience>) {
        experienceDao.insertAll(*data.toTypedArray())
    }

    override fun getData(): LiveData<List<Experience>> = experienceDao.getExperiencesAndInformations().map { experiences ->
        experiences.map { experience -> experience.toDomain() }
    }
}