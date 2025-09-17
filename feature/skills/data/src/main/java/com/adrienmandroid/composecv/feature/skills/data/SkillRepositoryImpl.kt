package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.SimpleListLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class SkillRepositoryImpl @Inject constructor(
    localDataSource: SkillLocalDataSource,
    remoteDataSource: SkillRemoteDataSource
) : SkillRepository {
    val simpleListLocalAndRemoteDataManager: SimpleListLocalAndRemoteDataManager<Skill> = SimpleListLocalAndRemoteDataManager(
        simpleListLocalDataSource = localDataSource,
        simpleListRemoteDataSource = remoteDataSource
    )

    override fun get(coroutineScope: CoroutineScope) = simpleListLocalAndRemoteDataManager.get(coroutineScope)
}