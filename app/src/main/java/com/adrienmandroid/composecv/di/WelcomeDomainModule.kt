package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.data.WelcomeElementsRepositoryImpl
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WelcomeDomainModule {
    @Binds
    abstract fun bindWelcomeRepository(
        welcomeRepositoryImpl: WelcomeElementsRepositoryImpl
    ): WelcomeElementsRepository
}