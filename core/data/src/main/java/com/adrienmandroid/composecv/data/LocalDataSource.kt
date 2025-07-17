package com.adrienmandroid.composecv.data

interface LocalDataSource<T> {
    fun getLocalData(): T
    fun setLocalData(t: T): Boolean
}