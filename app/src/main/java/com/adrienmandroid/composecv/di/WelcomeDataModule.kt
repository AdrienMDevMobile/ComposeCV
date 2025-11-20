package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.data.WelcomeElementsRepositoryImpl
import com.adrienmandroid.composecv.feature.data.WelcomeLocalDataSource
import com.adrienmandroid.composecv.feature.data.WelcomeRemoteDataSource
import com.adrienmandroid.composecv.feature.data.local.WelcomeLocalDataSourceRoomImpl
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteDataSourceApiImpl
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WelcomeDataModule {
    @Binds
    abstract fun bindWelcomeRepository(
        welcomeRepositoryImpl: WelcomeElementsRepositoryImpl
    ): WelcomeElementsRepository

    @Binds
    abstract fun bindWelcomeRemoteDataSource(
        welcomeRemoteDataSource: WelcomeRemoteDataSourceApiImpl
    ): WelcomeRemoteDataSource

    @Binds
    abstract fun bindWelcomeLocalDataSource(
        welcomeLocalDataSourceRoomImpl: WelcomeLocalDataSourceRoomImpl
    ) : WelcomeLocalDataSource
}