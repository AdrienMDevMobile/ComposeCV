package com.adrienmandroid.composecv.feature.experience.data

import com.adrienmandroid.composecv.data.SimpleListLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    localDataSource: ExperienceLocalDataSource,
    remoteDataSource: ExperienceRemoteDataSource
) : ExperienceRepository {
    val simpleListLocalAndRemoteDataManager: SimpleListLocalAndRemoteDataManager<Experience> =
        SimpleListLocalAndRemoteDataManager(
            simpleListLocalDataSource = localDataSource,
            simpleListRemoteDataSource = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) = simpleListLocalAndRemoteDataManager.get(coroutineScope)
}