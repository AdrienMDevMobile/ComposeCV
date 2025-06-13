package com.adrienmandroid.composecv.data.repository

import com.adrienmandroid.composecv.model.WelcomeElement

interface WelcomeElementsRepository {
    fun listOfWelcomeItems(): List<WelcomeElement>
}