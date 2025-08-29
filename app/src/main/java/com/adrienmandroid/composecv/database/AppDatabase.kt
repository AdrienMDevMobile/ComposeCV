package com.adrienmandroid.composecv.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.feature.skills.data.local.SkillDao
import com.adrienmandroid.composecv.feature.skills.data.local.Skill

@Database(entities = [Skill::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao
}