package com.adrienmandroid.composecv.data.repository

import com.adrienmandroid.composecv.model.welcome.WelcomeElement

interface WelcomeElementsRepository {
    fun listOfWelcomeItems(): List<WelcomeElement>
}