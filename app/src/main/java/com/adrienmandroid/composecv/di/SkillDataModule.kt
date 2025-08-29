package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.skills.data.local.SkillLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.skills.data.remote.SkillRemoteDataSourceJsonImpl
import com.adrienmandroid.composecv.feature.skills.data.SkillLocalDataSource
import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SkillDataModule {
    @Binds
    abstract fun bindSkillRemoteRepository(
        skillRemoteRepository: SkillRemoteDataSourceJsonImpl
    ): SkillRemoteDataSource

    @Binds
    abstract fun bindSkillLocalRepository(
        skillLocalRepository: SkillLocalDataSourceRoomImpl
    ): SkillLocalDataSource
}