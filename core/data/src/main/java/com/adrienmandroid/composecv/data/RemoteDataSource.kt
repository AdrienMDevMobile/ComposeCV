package com.adrienmandroid.composecv.data

interface RemoteDataSource<T> {
    fun getData(): List<T>
}