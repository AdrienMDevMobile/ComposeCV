package com.adrienmandroid.composecv.feature.welcome.domain.repository

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.response.Response
import kotlinx.coroutines.flow.Flow

interface WelcomeElementsRepository {
    fun get(): Flow<Response<WelcomeHeader, WelcomeBodyElement>>
}