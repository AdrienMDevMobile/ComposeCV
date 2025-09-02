package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.experience.data.ExperienceLocalDataSource
import com.adrienmandroid.composecv.feature.experience.data.ExperienceRepositoryImpl
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import com.adrienmandroid.composecv.feature.experience.data.ExperienceRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.experience.data.remote.ExperienceRemoteDataSourceJsonImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ExperienceDataModule {

    @Binds
    abstract fun bindExperienceRepository(
        experienceRepositoryImpl: ExperienceRepositoryImpl
    ): ExperienceRepository

    @Binds
    abstract fun bindExperienceRemoteRepository(
        experienceRemoteRepository: ExperienceRemoteDataSourceJsonImpl
    ): ExperienceRemoteDataSource

    @Binds
    abstract fun bindExperienceLocalRepository(
        experienceLocalRepository: ExperienceLocalDataSourceRoomImpl
    ): ExperienceLocalDataSource

}