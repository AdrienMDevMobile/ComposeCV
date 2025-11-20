package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.other.data.OtherLocalDataSource
import com.adrienmandroid.composecv.feature.other.data.OtherRemoteDataSource
import com.adrienmandroid.composecv.feature.other.data.local.OtherLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.other.data.remote.OtherRemoteDataSourceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindOtherRemoteDataSource(
        otherRemoteRepository: OtherRemoteDataSourceApiImpl
    ): OtherRemoteDataSource

    @Binds
    abstract fun bindOtherLocalDataSource(
        otherLocalRepository: OtherLocalDataSourceRoomImpl
    ): OtherLocalDataSource

}