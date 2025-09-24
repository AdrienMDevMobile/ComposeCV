package com.adrienmandroid.composecv.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceDao
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceEntity
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceInformation
import com.adrienmandroid.composecv.feature.other.data.local.GratitudeLocalEntity
import com.adrienmandroid.composecv.feature.other.data.local.HobbyLocalEntity
import com.adrienmandroid.composecv.feature.other.data.local.QuoteLocalEntity
import com.adrienmandroid.composecv.feature.other.data.local.StudyLocalEntity
import com.adrienmandroid.composecv.feature.other.data.local.dao.GratitudeDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.HobbyDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.QuoteDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.StudyDao
import com.adrienmandroid.composecv.feature.skills.data.local.Skill
import com.adrienmandroid.composecv.feature.skills.data.local.SkillDao

@Database(
    entities = [
        Skill::class,
        ExperienceEntity::class,
        ExperienceInformation::class,
        StudyLocalEntity::class,
        QuoteLocalEntity::class,
        HobbyLocalEntity::class,
        GratitudeLocalEntity::class,
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao
    abstract fun experienceDao(): ExperienceDao
    abstract fun studyDao(): StudyDao
    abstract fun quoteDao(): QuoteDao
    abstract fun hobbyDao(): HobbyDao
    abstract fun gratitudeDao(): GratitudeDao
}