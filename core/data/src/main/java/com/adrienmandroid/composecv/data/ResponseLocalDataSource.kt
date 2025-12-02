package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.response.Response
import kotlinx.coroutines.flow.Flow

interface ResponseLocalDataSource<H, L> {
    fun saveData(data: Response.Success<H, L>)
    fun getData(): Flow<Response<H, L>>
}

typealias BasicResponseLocalDataSource<T> = ResponseLocalDataSource<Unit, T>