package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.skills.data.local.SkillLocalRepositoryRoomImpl
import com.adrienmandroid.composecv.feature.skills.data.remote.SkillRemoteRepositoryJsonImpl
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillLocalRepository
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SkillDataModule {
    @Binds
    abstract fun bindSkillsRemoteRepository(
        skillRemoteRepository: SkillRemoteRepositoryJsonImpl
    ): SkillRemoteRepository

    @Binds
    abstract fun bindSkillsLocalRepository(
        skillLocalRepository: SkillLocalRepositoryRoomImpl
    ): SkillLocalRepository
}