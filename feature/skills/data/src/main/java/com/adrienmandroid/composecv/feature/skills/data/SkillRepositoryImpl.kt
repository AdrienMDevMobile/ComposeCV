package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.BasicResponseLocalAndRemoteManager
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import javax.inject.Inject

class SkillRepositoryImpl @Inject constructor(
    localDataSource: SkillLocalDataSource,
    remoteDataSource: SkillRemoteDataSource
) : SkillRepository {
    val responseLocalAndRemoteManager: BasicResponseLocalAndRemoteManager<Skill> =
        BasicResponseLocalAndRemoteManager(
            local = localDataSource,
            remote = remoteDataSource
        )

    override fun get() =
        responseLocalAndRemoteManager.get()
}