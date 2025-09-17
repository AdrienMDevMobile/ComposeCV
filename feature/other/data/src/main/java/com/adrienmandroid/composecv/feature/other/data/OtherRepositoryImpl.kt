package com.adrienmandroid.composecv.feature.other.data

import com.adrienmandroid.composecv.data.SimpleListLocalAndRemoteDataManager
import com.adrienmandroid.composecv.feature.other.VersionNameRepositoryImpl
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class OtherRepositoryImpl @Inject constructor(
    localDataSource: OtherLocalDataSource,
    remoteDataSource: OtherRemoteDataSource,
    val versionNameRepository: VersionNameRepositoryImpl,
) : OtherRepository {
    val localAndRemoteDataManager: SimpleListLocalAndRemoteDataManager<OtherComponent> =
        SimpleListLocalAndRemoteDataManager(
            simpleListLocalDataSource = localDataSource,
            simpleListRemoteDataSource = remoteDataSource
        )

    override fun get(coroutineScope: CoroutineScope) =
        localAndRemoteDataManager.get(coroutineScope)/*.transform { value ->
            emit(value.toMutableList().apply {
                add(OtherComponent.Version(versionNameRepository.getAppVersionName()))
            })
        }*/
}