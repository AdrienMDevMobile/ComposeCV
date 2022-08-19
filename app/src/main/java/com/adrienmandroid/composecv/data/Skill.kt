package com.adrienmandroid.composecv.data

data class Skill(
    val name: String,
    val targetValue: Float? = null,
    val subSkills: List<String> = emptyList(),
    val explanation: String
)
