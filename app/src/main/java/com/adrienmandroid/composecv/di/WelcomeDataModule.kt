package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.data.WelcomeElementsRepositoryImpl
import com.adrienmandroid.composecv.feature.data.WelcomeRemoteDataSource
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteDataSourceJsonImpl
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
    abstract fun bindWelcomeRemoteRepository(
        welcomeRemoteRepository: WelcomeRemoteDataSourceJsonImpl
    ): WelcomeRemoteDataSource

    /* TODO remove
    @Binds
    abstract fun bindWelcomeRepository(
        welcomeElementsRepository: WelcomeElementsRepositoryImpl
    ): WelcomeElementsRepository*/

}