package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.remote.NoConnectivityException
import com.adrienmandroid.composecv.model.response.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform

class ResponseLocalAndRemoteManager<H, L>(
    val local: ResponseLocalDataSource<H, L>,
    val remote: ResponseRemoteDataSource<H, L>,
) {
    //TODO remove parameter
    fun get(coroutineScope: CoroutineScope): Flow<Response<H, L>> = local.getData()
        .distinctUntilChanged().transform { localData ->
            if (localData is Response.Error) {
                try {
                    val remoteData = remote.getData()
                    if (remoteData is Response.Success) {
                        local.saveData(remoteData)
                    } else emit(remoteData)
                } catch (_: NoConnectivityException) {
                    emit(Response.Error())
                }
            } else {
                emit(localData)
            }
        }.flowOn(Dispatchers.IO)
}

typealias BasicResponseLocalAndRemoteManager<T> = ResponseLocalAndRemoteManager<Unit, T>