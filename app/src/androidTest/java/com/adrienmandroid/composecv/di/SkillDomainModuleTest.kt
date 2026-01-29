package com.adrienmandroid.composecv.di

import com.adrienmandroid.composecv.fake.SkillRepositoryEmptyImpl
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SkillDomainModule::class]
)
abstract class SkillDomainModuleTest {
    @Binds
    abstract fun bindSkillRepository(
        skillRepository: SkillRepositoryEmptyImpl
    ): SkillRepository
}