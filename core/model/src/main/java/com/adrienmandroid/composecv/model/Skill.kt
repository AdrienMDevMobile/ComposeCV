package com.adrienmandroid.composecv.model

data class Skill(
    val name: String,
    val targetValue: Float? = null,
    val subSkills: Pair<String, String>? = null,
    val explanation: String
)
