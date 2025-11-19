package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.skills.data.local.SkillLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.skills.data.SkillLocalDataSource
import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteDataSource
import com.adrienmandroid.composecv.feature.skills.data.remote.SkillRemoteDataSourceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SkillDataModule {
    @Binds
    abstract fun bindSkillRemoteRepository(
        skillRemoteRepository: SkillRemoteDataSourceApiImpl
    ): SkillRemoteDataSource

    @Binds
    abstract fun bindSkillLocalRepository(
        skillLocalRepository: SkillLocalDataSourceRoomImpl
    ): SkillLocalDataSource
}