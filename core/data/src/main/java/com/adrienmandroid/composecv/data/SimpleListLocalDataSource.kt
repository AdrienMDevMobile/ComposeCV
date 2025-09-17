package com.adrienmandroid.composecv.data

import kotlinx.coroutines.flow.Flow

interface SimpleListLocalDataSource<T> {
    fun saveData(data: List<T>)
    fun getData(): Flow<List<T>>
}