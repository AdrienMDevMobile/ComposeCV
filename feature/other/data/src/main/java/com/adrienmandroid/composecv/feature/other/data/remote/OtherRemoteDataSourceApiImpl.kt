package com.adrienmandroid.composecv.feature.other.data.remote

import com.adrienmandroid.composecv.data.remote.RetrofitInstance
import com.adrienmandroid.composecv.feature.other.data.OtherRemoteDataSource
import com.adrienmandroid.composecv.feature.other.data.converter.toDomain
import com.adrienmandroid.composecv.feature.other.data.remote.api.OtherApi
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import javax.inject.Inject

class OtherRemoteDataSourceApiImpl @Inject constructor() : OtherRemoteDataSource {
    val otherApi : OtherApi = RetrofitInstance.retrofit.create(OtherApi::class.java)
    
    override suspend fun getData(): Response<Unit, OtherComponent> {
        val response = otherApi.getOther()
        
        return listOf(
            OtherComponent.Studies(response.studies.map { it.toDomain() }),
            OtherComponent.Hobbies(response.hobbies.map { it.toDomain() }),
            OtherComponent.Quotes(response.quotes.map { it.toDomain() }),
            OtherComponent.Gratitudes(response.gratitudes.map { it.text })
        ).toResponse()
    }
}