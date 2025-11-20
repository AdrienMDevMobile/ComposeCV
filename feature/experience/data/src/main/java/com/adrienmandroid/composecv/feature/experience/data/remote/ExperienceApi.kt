package com.adrienmandroid.composecv.feature.experience.data.remote

import retrofit2.http.GET

interface ExperienceApi {
    @GET("/fr/experience/experiences.json")
    suspend fun getExperiences(): List<ExperienceRemoteBody>
}