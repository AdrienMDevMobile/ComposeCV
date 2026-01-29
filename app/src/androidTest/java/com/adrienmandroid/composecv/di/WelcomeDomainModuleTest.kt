package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.fake.WelcomeElementsRepositoryEmptyImpl
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [WelcomeDomainModule::class]
)
abstract class WelcomeDomainModuleTest {
    @Binds
    abstract fun bindWelcomeRepositoryTest(
        welcomeRepositoryImpl: WelcomeElementsRepositoryEmptyImpl
    ): WelcomeElementsRepository
}