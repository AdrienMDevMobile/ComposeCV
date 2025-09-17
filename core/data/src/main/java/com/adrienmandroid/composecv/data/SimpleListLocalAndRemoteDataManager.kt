package com.adrienmandroid.composecv.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class SimpleListLocalAndRemoteDataManager<T>(
    val simpleListLocalDataSource: SimpleListLocalDataSource<T>,
    val simpleListRemoteDataSource: SimpleListRemoteDataSource<T>
) {
    fun get(coroutineScope: CoroutineScope): Flow<List<T>> = simpleListLocalDataSource.getData()
        .distinctUntilChanged().transform { local ->
            if (local.isEmpty()) {
                coroutineScope.launch(Dispatchers.IO) {
                    simpleListLocalDataSource.saveData(simpleListRemoteDataSource.getData())
                }
                //emit(emptyList())
            } else {
                emit(local)
            }
        }
}