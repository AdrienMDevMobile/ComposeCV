package com.adrienmandroid.composecv.feature.experience.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.adrienmandroid.composecv.feature.experience.data.converter.toLocalData
import com.adrienmandroid.composecv.feature.experience.data.converter.toLocalDataEntity
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation as ExperienceInformationDomain

@Dao
interface ExperienceDao {
    fun insertAll(vararg experiences: Experience) {
        experiences.forEach { experience ->
            insertExperienceAndItsInformation(experience)
        }
    }

    @Transaction
    @Query("SELECT * FROM experiences")
    fun getExperiencesAndInformations(): LiveData<List<ExperienceWithInformation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExperienceEntityAndReturnId(experience: ExperienceEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllInformation(informations: List<ExperienceInformation>)

    @Transaction
    fun insertExperienceAndItsInformation(experience: Experience) {
        val experienceId = insertExperienceEntityAndReturnId(experience.toLocalDataEntity())
        convertInformationAndInsert(experienceId, experience.informations)
    }

    private fun convertInformationAndInsert(
        experienceId: Long,
        informations: List<ExperienceInformationDomain>
    ) {
        val informationEntities = informations.map {
            it.toLocalData(parentId = experienceId)
        }
        if (informationEntities.isNotEmpty()) {
            insertAllInformation(informationEntities)
        }
    }
}