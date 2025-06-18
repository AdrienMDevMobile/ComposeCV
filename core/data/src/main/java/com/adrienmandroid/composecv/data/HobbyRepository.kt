package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Hobby

interface HobbyRepository {
    fun getHobbies(): List<Hobby>
}