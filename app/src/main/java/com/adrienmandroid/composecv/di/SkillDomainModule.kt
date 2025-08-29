package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.feature.skills.data.SkillRepositoryImpl
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class SkillDomainModule {
    @Binds
    abstract fun bindSkillRepository(
        skillRepository: SkillRepositoryImpl
    ): SkillRepository
}