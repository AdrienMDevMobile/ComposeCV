package com.adrienmandroid.composecv.feature.skills.domain.model

data class Skill(
    var uid: Int = 0,
    val name: String,
    val targetValue: Float? = null,
    val subSkills: Pair<String, String>? = null,
    val explanation: String
)
