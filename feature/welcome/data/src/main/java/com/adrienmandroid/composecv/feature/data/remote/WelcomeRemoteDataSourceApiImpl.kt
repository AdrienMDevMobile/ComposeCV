package com.adrienmandroid.composecv.feature.data.remote

import android.content.Context
import com.adrienmandroid.composecv.data.remote.RetrofitInstance
import com.adrienmandroid.composecv.feature.data.WelcomeRemoteDataSource
import com.adrienmandroid.composecv.feature.data.converter.toDomain
import com.adrienmandroid.composecv.feature.data.remote.api.WelcomeApi
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WelcomeRemoteDataSourceApiImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : WelcomeRemoteDataSource {
    val api: WelcomeApi = RetrofitInstance.getInstance(context).create(WelcomeApi::class.java)
    override suspend fun getData(): Response<WelcomeHeader, WelcomeBodyElement> {
        val response = api.getWelcome()
        return response.body.toList()
            .mapNotNull { element -> element.toDomain() }
            .toResponse(
                response.header.toDomain())
    }
}