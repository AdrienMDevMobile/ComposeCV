package com.adrienmandroid.composecv.feature.data

import com.adrienmandroid.composecv.data.ResponseLocalAndRemoteManager
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class WelcomeElementsRepositoryImpl @Inject constructor(
    localDataSource: WelcomeLocalDataSource,
    remoteDataSource: WelcomeRemoteDataSource
) : WelcomeElementsRepository {

    val responseLocalAndRemoteManager: ResponseLocalAndRemoteManager<WelcomeHeader, WelcomeBodyElement> =
        ResponseLocalAndRemoteManager(
            local = localDataSource,
            remote = remoteDataSource,
        )

    override fun get() =
        responseLocalAndRemoteManager.get()
}