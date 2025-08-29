package com.adrienmandroid.composecv.feature.skills.data.remote

data class Skills( // Assure que Moshi mappe la clé JSON "skills" à cette propriété
    val skills: List<Skill>
)