package com.adrienmandroid.composecv.data

class LocalAndRemoteDataManager<T>(
    val localDataSource: LocalDataSource<T>,
    val remoteDataSource: RemoteDataSource<T>
) {
    suspend fun getData(): T = localDataSource.getLocalData() ?: updateData()

    suspend fun updateData(): T {
        val remoteData = remoteDataSource.getDataFromRemote()
        localDataSource.setLocalData(remoteData)
        return remoteData
    }
}