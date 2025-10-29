package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.ResponseLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class SkillRepositoryImpl @Inject constructor(
    localDataSource: SkillLocalDataSource,
    remoteDataSource: SkillRemoteDataSource
) : SkillRepository {
    val responseLocalAndRemoteDataManager: ResponseLocalAndRemoteDataManager<Void, Skill> =
        ResponseLocalAndRemoteDataManager(
            local = localDataSource,
            remote = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) =
        responseLocalAndRemoteDataManager.get(coroutineScope)
}