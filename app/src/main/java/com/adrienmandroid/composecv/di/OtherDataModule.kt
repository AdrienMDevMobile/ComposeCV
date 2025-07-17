package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.other.domain.repository.GratitudeRepository
import com.adrienmandroid.composecv.feature.other.domain.repository.HobbyRepository
import com.adrienmandroid.composecv.feature.other.domain.repository.QuoteRepository
import com.adrienmandroid.composecv.feature.other.domain.repository.StudyRepository
import com.adrienmandroid.composecv.feature.other.domain.repository.VersionNameRepository
import com.adrienmandroid.composecv.feature.other.GratitudeRepositoryImpl
import com.adrienmandroid.composecv.feature.other.HobbyRepositoryImpl
import com.adrienmandroid.composecv.feature.other.QuoteRepositoryImpl
import com.adrienmandroid.composecv.feature.other.StudyRepositoryImpl
import com.adrienmandroid.composecv.feature.other.VersionNameRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindStudyRepository(
        studyRepositoryImpl: StudyRepositoryImpl
    ): StudyRepository

    @Binds
    abstract fun bindQuoteRepository(
        quoteRepositoryImpl: QuoteRepositoryImpl
    ): QuoteRepository

    @Binds
    abstract fun bindHobbyRepository(
        hobbyRepositoryImpl: HobbyRepositoryImpl
    ): HobbyRepository

    @Binds
    abstract fun bindGratitudeRepository(
        gratitudeRepositoryImpl: GratitudeRepositoryImpl
    ): GratitudeRepository

    @Binds
    abstract fun bindVersionRepository(
        versionRepositoryImpl: VersionNameRepositoryImpl
    ): VersionNameRepository
}