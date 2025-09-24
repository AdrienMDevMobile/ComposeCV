package com.adrienmandroid.composecv.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class SimpleListLocalAndRemoteDataManager<T>(
    val local: SimpleListLocalDataSource<T>,
    val remote: SimpleListRemoteDataSource<T>
) {
    fun get(coroutineScope: CoroutineScope): Flow<List<T>> = local.getData()
        .distinctUntilChanged().transform { localData ->
            if (localData.isEmpty()) {
                coroutineScope.launch(Dispatchers.IO) {
                    local.saveData(remote.getData())
                }
            } else {
                emit(localData)
            }
        }
}