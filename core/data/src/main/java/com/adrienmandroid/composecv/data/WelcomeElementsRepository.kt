package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.welcome.WelcomeElement

interface WelcomeElementsRepository {
    fun listOfWelcomeItems(): List<WelcomeElement>
}