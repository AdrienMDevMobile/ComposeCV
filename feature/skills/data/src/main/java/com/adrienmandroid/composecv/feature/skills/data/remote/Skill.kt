package com.adrienmandroid.composecv.feature.skills.data.remote

data class Skill(
    var uid: Int = 0,
    val name: String,
    val targetValue: Float? = null,
    val subSkills: SubSkills? = null,
    val explanation: String
)

data class SubSkills(val first: String, val second: String)