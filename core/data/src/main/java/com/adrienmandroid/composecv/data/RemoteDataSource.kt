package com.adrienmandroid.composecv.data

import androidx.lifecycle.LiveData

interface RemoteDataSource<T> {
    fun getData(): List<T>
}