package com.adrienmandroid.composecv.data.di

import com.adrienmandroid.composecv.data.ExperienceRepository
import com.adrienmandroid.composecv.data.GratitudeRepository
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.QuoteRepository
import com.adrienmandroid.composecv.data.SkillRepository
import com.adrienmandroid.composecv.data.StudyRepository
import com.adrienmandroid.composecv.data.VersionNameRepository
import com.adrienmandroid.composecv.data.WelcomeElementsRepository
import com.adrienmandroid.composecv.data.impl.ExperienceRepositoryImpl
import com.adrienmandroid.composecv.data.impl.GratitudeRepositoryImpl
import com.adrienmandroid.composecv.data.impl.HobbyRepositoryImpl
import com.adrienmandroid.composecv.data.impl.QuoteRepositoryImpl
import com.adrienmandroid.composecv.data.impl.SkillRepositoryImpl
import com.adrienmandroid.composecv.data.impl.StudyRepositoryImpl
import com.adrienmandroid.composecv.data.impl.VersionNameRepositoryImpl
import com.adrienmandroid.composecv.data.impl.WelcomeElementsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindWelcomeRepository(
        welcomeElementsRepository: WelcomeElementsRepositoryImpl
    ): WelcomeElementsRepository

    @Binds
    abstract fun bindSkillsRepository(
        skillRepository: SkillRepositoryImpl
    ): SkillRepository

    @Binds
    abstract fun bindExperienceRepository(
        experienceRepositoryImpl: ExperienceRepositoryImpl
    ): ExperienceRepository

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