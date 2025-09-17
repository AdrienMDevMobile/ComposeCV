package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface OtherRepository {
    fun get(coroutineScope: CoroutineScope): Flow<List<OtherComponent>>
}