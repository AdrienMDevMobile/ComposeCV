package com.adrienmandroid.composecv.feature.data.remote

import com.adrienmandroid.composecv.feature.data.WelcomeRemoteDataSource
import com.adrienmandroid.composecv.feature.data.converter.toDomain
import com.adrienmandroid.composecv.feature.data.remote.api.WelcomeApi
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import retrofit2.Retrofit
import javax.inject.Inject

class WelcomeRemoteDataSourceApiImpl @Inject constructor(
    retrofit: Retrofit
) : WelcomeRemoteDataSource {
    private val api: WelcomeApi = retrofit.create(WelcomeApi::class.java)
    override suspend fun getData(): Response<WelcomeHeader, WelcomeBodyElement> {
        val response = api.getWelcome()
        return response.body.toList()
            .mapNotNull { element -> element.toDomain() }
            .toResponse(
                response.header.toDomain()
            )
    }
}