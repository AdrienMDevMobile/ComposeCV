package com.adrienmandroid.composecv.feature.skills.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class SkillRemoteBody(
    val name: String,
    val targetValue: Float? = null,
    val subSkills: SubSkillsRemoteBody? = null,
    val explanation: String
)

@Serializable
data class SubSkillsRemoteBody(val first: String, val second: String)