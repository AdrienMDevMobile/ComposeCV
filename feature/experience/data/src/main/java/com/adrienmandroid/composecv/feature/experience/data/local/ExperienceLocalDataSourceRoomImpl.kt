package com.adrienmandroid.composecv.feature.experience.data.local

import com.adrienmandroid.composecv.feature.experience.data.ExperienceLocalDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.BasicResponseSuccess
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExperienceLocalDataSourceRoomImpl @Inject constructor (
    private val experienceDao: ExperienceDao,
): ExperienceLocalDataSource {
    override fun saveData(data: BasicResponseSuccess<Experience>) {
        experienceDao.insertAll(*data.page.toTypedArray())
    }

    override fun getData(): Flow<BasicResponse<Experience>> = experienceDao.getExperiencesAndInformationsAsFlow().map { experiences ->
        if(experiences.isNotEmpty()){
            experiences.map { experience -> experience.toDomain() }.toResponse()
        } else {
            Response.Error()
        }
    }
}