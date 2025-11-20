package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.experience.data.ExperienceLocalDataSource
import com.adrienmandroid.composecv.feature.experience.data.ExperienceRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.experience.data.remote.ExperienceRemoteDataSourceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ExperienceDataModule {
    @Binds
    abstract fun bindExperienceRemoteDataSource(
        experienceRemoteRepository: ExperienceRemoteDataSourceApiImpl
    ): ExperienceRemoteDataSource

    @Binds
    abstract fun bindExperienceLocalDataSource(
        experienceLocalRepository: ExperienceLocalDataSourceRoomImpl
    ): ExperienceLocalDataSource

}