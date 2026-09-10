package com.adrienmandroid.composecv.feature.skills.domain.model

sealed class Skill(var uid: Int = 0, val name: String, val explanation: String) {
    class PercentageSkill(
        uid: Int = 0,
        name: String,
        explanation: String,
        val targetValue: Float,
    ) : Skill(uid, name, explanation)

    class Subskills(
        uid: Int = 0,
        name: String,
        explanation: String,
        val subSkills: Pair<String, String>
    ) : Skill(uid, name, explanation)
}