package com.adrienmandroid.composecv.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceDao
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceEntity
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceInformation
import com.adrienmandroid.composecv.feature.skills.data.local.Skill
import com.adrienmandroid.composecv.feature.skills.data.local.SkillDao

@Database(
    entities = [
        Skill::class,
        ExperienceEntity::class,
        ExperienceInformation::class,
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao
    abstract fun experienceDao(): ExperienceDao
}