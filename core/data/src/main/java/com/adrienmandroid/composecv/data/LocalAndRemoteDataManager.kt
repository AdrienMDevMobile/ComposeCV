package com.adrienmandroid.composecv.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.liveData

abstract class LocalAndRemoteDataManager<T>(
    val localDataSource: LocalDataSource<T>,
    val remoteDataSource: RemoteDataSource<T>
) {
    fun get(coroutineScope: CoroutineScope): LiveData<List<T>> = liveData {
        val source = localDataSource.getData()
            .distinctUntilChanged() // Pour éviter les re-calculs inutiles
        //mediator live data permet d'appliquer la transformation sur notre live data
        emitSource(MediatorLiveData<List<T>>().apply {
            //source de notre live data que nous allons modifier.
            addSource(source) { data ->
                if (data.isEmpty()) {
                    coroutineScope.launch(Dispatchers.IO) {
                        localDataSource.saveData(remoteDataSource.getData())
                    }
                    value = emptyList()
                } else {
                    value = data
                }
            }
        })
    }
}