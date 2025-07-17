package com.adrienmandroid.composecv.data

interface LocalDataSource<T> {
    suspend fun getLocalData(): T?
    suspend fun setLocalData(t: T): Boolean
}