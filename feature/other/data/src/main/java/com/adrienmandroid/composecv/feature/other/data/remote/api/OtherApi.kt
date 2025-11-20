package com.adrienmandroid.composecv.feature.other.data.remote.api

import com.adrienmandroid.composecv.feature.other.data.remote.OtherJsonBody
import retrofit2.http.GET

interface OtherApi {
    @GET("/fr/others/others.json")
    suspend fun getOther(): OtherJsonBody
}