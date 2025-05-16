package com.adrienmandroid.composecv.data.model

data class Skill(
    val name: String,
    val targetValue: Float? = null,
    val subSkills: List<String> = emptyList(),
    val explanation: String
)
