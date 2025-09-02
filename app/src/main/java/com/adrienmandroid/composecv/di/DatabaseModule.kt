package com.adrienmandroid.composecv.di

import android.content.Context
import androidx.room.Room
import com.adrienmandroid.composecv.database.AppDatabase
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceDao
import com.adrienmandroid.composecv.feature.skills.data.local.SkillDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideSkillDao(appDatabase: AppDatabase): SkillDao {
        return  appDatabase.skillDao()
    }

    @Provides
    fun provideExperienceDao(appDatabase: AppDatabase): ExperienceDao {
        return  appDatabase.experienceDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            AppDatabase::class.java,
            "cv_compose_database"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }
}