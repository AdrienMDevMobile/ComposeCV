package com.adrienmandroid.composecv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.feature.skills.data.SkillDao
import com.adrienmandroid.composecv.feature.skills.data.SkillData


@Database(entities = [SkillData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao
}

// Singleton Pattern for database instance
object DatabaseClient {
    private var _instance: AppDatabase? = null
    private val INSTANCE: AppDatabase
        get() = _instance ?: throw IllegalStateException("No database instance")

    @Synchronized
    fun getInstance(context: Context): AppDatabase {
        if (_instance == null) {
            synchronized(AppDatabase::class.java) {
                if (_instance == null) {
                    _instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "cv_compose_database"
                    ) // Wipes and rebuilds instead of migrating
                        // if no Migration object.
                        //.addTypeConverter(DateConverter)
                        .fallbackToDestructiveMigration(false)
                        .build()
                }
            }
        }
        return INSTANCE
    }
}