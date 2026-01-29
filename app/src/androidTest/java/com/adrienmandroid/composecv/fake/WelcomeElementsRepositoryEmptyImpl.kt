package com.adrienmandroid.composecv.fake

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import com.adrienmandroid.composecv.model.response.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WelcomeElementsRepositoryEmptyImpl : WelcomeElementsRepository {
    override fun get(): Flow<Response<WelcomeHeader, WelcomeBodyElement>> = flow {
        //emit()
    }
}