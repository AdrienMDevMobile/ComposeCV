package com.adrienmandroid.composecv.feature.skills.domain.model

data class Skill(
    val name: String,
    val targetValue: Float? = null,
    // Remplacer pair par quelque chose d'autre ? sinon mettre un adapteur
    val subSkills: SubSkills? = null,
    val explanation: String
)
