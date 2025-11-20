package com.adrienmandroid.composecv.feature.data.remote.api

import com.adrienmandroid.composecv.feature.data.remote.elements.WelcomeRemoteResponse
import retrofit2.http.GET

interface WelcomeApi {
    @GET("/fr/welcome/welcome.json")
    suspend fun getWelcome(): WelcomeRemoteResponse
}