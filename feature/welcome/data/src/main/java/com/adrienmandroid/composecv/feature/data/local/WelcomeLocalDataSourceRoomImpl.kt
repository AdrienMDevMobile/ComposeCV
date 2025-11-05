package com.adrienmandroid.composecv.feature.data.local

import com.adrienmandroid.composecv.feature.data.WelcomeLocalDataSource
import com.adrienmandroid.composecv.feature.data.converter.toDomain
import com.adrienmandroid.composecv.feature.data.converter.toLocalData
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WelcomeLocalDataSourceRoomImpl @Inject constructor(
    private val welcomeElementsDao: WelcomeElementsDao,
) : WelcomeLocalDataSource {
    override fun saveData(data: Response<WelcomeHeader, WelcomeBodyElement>) {
        welcomeElementsDao.insertAllWelcomeElements(
            *data.page.map { element -> element.toLocalData() }.toTypedArray()
        )
    }

    //TODO add header
    override fun getData(): Flow<Response<WelcomeHeader, WelcomeBodyElement>> =
        welcomeElementsDao.getAllWelcomeElementsAsFlow().map { elements ->
            elements.mapNotNull { element ->
                element.toDomain()
            }.toResponse(
                null
            )
        }

}