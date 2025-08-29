package com.adrienmandroid.composecv.data

import androidx.lifecycle.LiveData

interface LocalDataSource<T> {
    fun saveData(data: List<T>)
    fun getData(): LiveData<List<T>>
}