package com.adrienmandroid.composecv.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class LocalAndRemoteDataManager<T>(
    val localDataSource: LocalDataSource<T>,
    val remoteDataSource: RemoteDataSource<T>
) {
    fun get(coroutineScope: CoroutineScope): Flow<List<T>> = localDataSource.getData()
        .distinctUntilChanged().transform { local ->
            if (local.isEmpty()) {
                coroutineScope.launch(Dispatchers.IO) {
                    localDataSource.saveData(remoteDataSource.getData())
                }
                //emit(emptyList())
            } else {
                emit(local)
            }
        }
}