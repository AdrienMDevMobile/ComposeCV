package com.adrienmandroid.composecv.feature.other.data

import com.adrienmandroid.composecv.data.SimpleListLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class OtherRepositoryImpl @Inject constructor(
    localDataSource: OtherLocalDataSource,
    remoteDataSource: OtherRemoteDataSource,
    val versionNameRepository: VersionNameRepository,
) : OtherRepository {
    val localAndRemoteDataManager: SimpleListLocalAndRemoteDataManager<OtherComponent> =
        SimpleListLocalAndRemoteDataManager(
            simpleListLocalDataSource = localDataSource,
            simpleListRemoteDataSource = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) =
        localAndRemoteDataManager.get(coroutineScope).transform { value ->
            emit(value.toMutableList().apply {
                add(OtherComponent.Version(versionNameRepository.getAppVersionName()))
                add(OtherComponent.Signature)
            })
        }
}