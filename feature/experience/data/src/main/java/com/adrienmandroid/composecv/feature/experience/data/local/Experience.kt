package com.adrienmandroid.composecv.feature.experience.data.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class ExperienceWithInformation(
    @Embedded
    val experience: ExperienceEntity, //pointe sur la classe entity
    @Relation(
        parentColumn = "experienceId",
        entityColumn = "parentExperienceId"
    ) //one to many
    val informations: List<ExperienceInformation>
)

@Entity(tableName = "experiences")
data class ExperienceEntity(
    @PrimaryKey(autoGenerate = true)
    val experienceId: Long = 0, // Primary key for the experience
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "employer")
    val employer: String? = null,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String,
    @ColumnInfo(name = "date_start")
    val dateStart: String,
    @ColumnInfo(name = "date_end")
    val dateEnd: String?,
    @ColumnInfo(name = "professional")
    val professional: Boolean,
)

@Entity(tableName = "experience_information")
data class ExperienceInformation(
    @PrimaryKey(autoGenerate = true)
    val informationId: Long = 0, // Primary key for this information entry
    val parentExperienceId: Long, // Foreign key to link back to ExperienceEntity
    val name: String
)