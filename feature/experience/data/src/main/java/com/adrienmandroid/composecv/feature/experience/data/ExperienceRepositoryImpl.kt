package com.adrienmandroid.composecv.feature.experience.data

import com.adrienmandroid.composecv.data.ResponseLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    localDataSource: ExperienceLocalDataSource,
    remoteDataSource: ExperienceRemoteDataSource
) : ExperienceRepository {
    val localAndRemoteDataManager: ResponseLocalAndRemoteDataManager<Unit, Experience> =
        ResponseLocalAndRemoteDataManager(
            local = localDataSource,
            remote = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) = localAndRemoteDataManager.get(coroutineScope)
}