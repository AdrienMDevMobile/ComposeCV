package com.adrienmandroid.composecv.data

interface RemoteDataSource<T> {
    suspend fun getDataFromRemote(
        //Shared web call/local file with all the infos
    ): T
}