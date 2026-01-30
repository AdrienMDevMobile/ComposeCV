package com.adrienmandroid.composecv.fake

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WelcomeElementsRepositoryEmptyImpl @Inject constructor() : WelcomeElementsRepository {
    override fun get(): Flow<Response<WelcomeHeader, WelcomeBodyElement>> = flow {
        emit(emptyList<WelcomeBodyElement>().toResponse(WelcomeHeader("", "")))
    }
}