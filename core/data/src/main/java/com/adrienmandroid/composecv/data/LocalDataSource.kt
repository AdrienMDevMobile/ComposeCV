package com.adrienmandroid.composecv.data

import kotlinx.coroutines.flow.Flow

interface LocalDataSource<T> {
    fun saveData(data: List<T>)
    fun getData(): Flow<List<T>>
}