package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.data.Hobby

interface HobbyDataSource {
    fun getHobbies(): List<Hobby>
}