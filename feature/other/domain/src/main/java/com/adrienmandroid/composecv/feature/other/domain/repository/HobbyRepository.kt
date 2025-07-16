package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.Hobby

interface HobbyRepository {
    fun getHobbies(): List<Hobby>
}