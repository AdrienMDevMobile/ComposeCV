package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.other.data.OtherRepositoryImpl
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OtherDomainModule {
    @Binds
    abstract fun bindOtherRepository(
        skillRepository: OtherRepositoryImpl
    ): OtherRepository
}