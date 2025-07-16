package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.experience.data.ExperienceRepositoryImpl
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
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

}