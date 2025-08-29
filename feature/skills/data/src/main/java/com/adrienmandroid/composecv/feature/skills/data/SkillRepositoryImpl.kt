package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.LocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class SkillRepositoryImpl @Inject constructor(
    localDataSource: SkillLocalDataSource,
    remoteDataSource: SkillRemoteDataSource
) : SkillRepository {
    val localAndRemoteDataManager: LocalAndRemoteDataManager<Skill> = LocalAndRemoteDataManager(
        localDataSource = localDataSource,
        remoteDataSource = remoteDataSource
    )

    override fun get(coroutineScope: CoroutineScope) = localAndRemoteDataManager.get(coroutineScope)
}