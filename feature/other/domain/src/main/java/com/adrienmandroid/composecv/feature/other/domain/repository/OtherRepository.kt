package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.model.response.BasicResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface OtherRepository {
    fun get(): Flow<BasicResponse<OtherComponent>>
}