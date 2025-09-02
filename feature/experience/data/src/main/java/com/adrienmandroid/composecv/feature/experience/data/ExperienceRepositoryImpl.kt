package com.adrienmandroid.composecv.feature.experience.data

import com.adrienmandroid.composecv.data.LocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    localDataSource: ExperienceLocalDataSource,
    remoteDataSource: ExperienceRemoteDataSource
) : ExperienceRepository {
    val localAndRemoteDataManager: LocalAndRemoteDataManager<Experience> =
        LocalAndRemoteDataManager(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) = localAndRemoteDataManager.get(coroutineScope)
}