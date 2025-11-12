package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.response.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class ResponseLocalAndRemoteManager<H, L>(
    val local: ResponseLocalDataSource<H, L>,
    val remote: ResponseRemoteDataSource<H, L>
) {
    fun get(coroutineScope: CoroutineScope): Flow<Response<H, L>> = local.getData()
        .distinctUntilChanged().transform { localData ->
            if (localData.header == null && localData.page.isEmpty()) {
                coroutineScope.launch(Dispatchers.IO) {
                    local.saveData(remote.getData())
                }
            } else {
                emit(localData)
            }
        }
}

typealias BasicResponseLocalAndRemoteManager<T>  = ResponseLocalAndRemoteManager<Unit, T>