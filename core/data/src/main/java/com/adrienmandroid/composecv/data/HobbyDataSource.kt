package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Hobby

interface HobbyDataSource {
    fun getHobbies(): List<Hobby>
}