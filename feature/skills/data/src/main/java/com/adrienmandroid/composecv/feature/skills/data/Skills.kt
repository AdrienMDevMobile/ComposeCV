package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

data class Skills( // Assure que Moshi mappe la clé JSON "skills" à cette propriété
    val skills: List<Skill>
)