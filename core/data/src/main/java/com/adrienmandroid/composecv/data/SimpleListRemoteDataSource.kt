package com.adrienmandroid.composecv.data

interface SimpleListRemoteDataSource<T> {
    fun getData(): List<T>
}