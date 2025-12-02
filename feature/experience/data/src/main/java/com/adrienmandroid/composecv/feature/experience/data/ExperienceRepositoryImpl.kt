package com.adrienmandroid.composecv.feature.experience.data

import com.adrienmandroid.composecv.data.BasicResponseLocalAndRemoteManager
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    localDataSource: ExperienceLocalDataSource,
    remoteDataSource: ExperienceRemoteDataSource
) : ExperienceRepository {
    val localAndRemoteDataManager: BasicResponseLocalAndRemoteManager<Experience> =
        BasicResponseLocalAndRemoteManager(
            local = localDataSource,
            remote = remoteDataSource
        )

    override fun get() = localAndRemoteDataManager.get()
}