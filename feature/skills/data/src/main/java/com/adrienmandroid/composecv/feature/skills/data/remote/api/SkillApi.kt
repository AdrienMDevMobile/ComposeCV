package com.adrienmandroid.composecv.feature.skills.data.remote.api

import com.adrienmandroid.composecv.feature.skills.data.remote.SkillRemoteBody
import retrofit2.http.GET

interface SkillApi {
    @GET("/fr/skills/skills.json")
    suspend fun getSkills(): List<SkillRemoteBody>


}