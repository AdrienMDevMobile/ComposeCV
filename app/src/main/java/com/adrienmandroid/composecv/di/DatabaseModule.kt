package com.adrienmandroid.composecv.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.database.AppDatabase
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.HobbyDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.QuoteDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.StudyDao
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
    fun provideStudyDao(appDatabase: AppDatabase): StudyDao {
        return  appDatabase.studyDao()
    }

    @Provides
    fun provideQuoteDao(appDatabase: AppDatabase): QuoteDao {
        return  appDatabase.quoteDao()
    }

    @Provides
    fun provideHobbyDao(appDatabase: AppDatabase): HobbyDao {
        return  appDatabase.hobbyDao()
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

    @Provides
    @Singleton
    fun provideRoomDatabase(appDatabase: AppDatabase): RoomDatabase {
        return appDatabase
    }
}