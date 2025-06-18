package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.WelcomePage

interface WelcomeElementsRepository {
    fun getWelcomePageElements(): WelcomePage
}