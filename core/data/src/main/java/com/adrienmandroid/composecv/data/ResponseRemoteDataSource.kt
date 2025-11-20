package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.response.Response

interface ResponseRemoteDataSource<H, L> {
    suspend fun getData(): Response<H, L>
}

typealias BasicResponseRemoteDataSource<T> = ResponseRemoteDataSource<Unit, T>