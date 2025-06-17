package com.adrienmandroid.composecv.data.repository

import com.adrienmandroid.composecv.model.WelcomePage

interface WelcomeElementsRepository {
    fun getWelcomePageElements(): WelcomePage
}