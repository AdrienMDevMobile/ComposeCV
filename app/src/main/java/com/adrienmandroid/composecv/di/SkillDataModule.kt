package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteRepositoryImpl
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SkillDataModule {
    @Binds
    abstract fun bindSkillsRepository(
        skillRepository: SkillRemoteRepositoryImpl
    ): SkillRemoteRepository
}