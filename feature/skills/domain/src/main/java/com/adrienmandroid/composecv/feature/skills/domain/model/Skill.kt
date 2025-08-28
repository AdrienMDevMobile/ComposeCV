package com.adrienmandroid.composecv.feature.skills.domain.model

data class Skill(
    var uid: Int = 0,
    val name: String,
    val targetValue: Float? = null,
    //TODO creer une classe Skill pour json. Adapté aux contraintes de moshi
    val subSkills: SubSkills? = null,
    //val subSkills: Pair<String, String>? = null,
    val explanation: String
)
