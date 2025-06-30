package com.adrienmandroid.composecv.data.di

import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.StudyRepository
import com.adrienmandroid.composecv.data.impl.HobbyRepositoryImpl
import com.adrienmandroid.composecv.data.impl.StudyRepositoryImpl
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
    abstract fun bindHobbyRepository(
        hobbyRepositoryImpl: HobbyRepositoryImpl
    ): HobbyRepository
}