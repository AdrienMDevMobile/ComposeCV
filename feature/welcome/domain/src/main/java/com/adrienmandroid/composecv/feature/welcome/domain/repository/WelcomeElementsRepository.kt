package com.adrienmandroid.composecv.feature.welcome.domain.repository

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomePage

interface WelcomeElementsRepository {
    fun getWelcomePageElements(): WelcomePage
}