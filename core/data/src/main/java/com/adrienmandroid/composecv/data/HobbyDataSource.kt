package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.model.Hobby

interface HobbyDataSource {
    fun getHobbies(): List<Hobby>
}