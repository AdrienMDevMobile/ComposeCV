package com.adrienmandroid.composecv.feature.other.data

import com.adrienmandroid.composecv.data.BasicResponseLocalAndRemoteManager
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class OtherRepositoryImpl @Inject constructor(
    localDataSource: OtherLocalDataSource,
    remoteDataSource: OtherRemoteDataSource,
    val versionNameRepository: VersionNameRepository,
) : OtherRepository {
    val localAndRemoteDataManager: BasicResponseLocalAndRemoteManager<OtherComponent> =
        BasicResponseLocalAndRemoteManager(
            local = localDataSource,
            remote = remoteDataSource
        )

    override fun get() =
        localAndRemoteDataManager.get().transform { value ->
            if(value is Response.Success){
                emit(value.page.toMutableList().apply {
                    add(OtherComponent.Version(versionNameRepository.getAppVersionName()))
                    add(OtherComponent.Signature)
                }.toResponse())
            }
            else {
                emit(value)
            }
        }
}