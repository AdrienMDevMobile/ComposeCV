package com.adrienmandroid.composecv.feature.welcome.ui.viewmodel

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader

class WelcomePageUiState (
    val header: WelcomeHeader,
    val body: List<WelcomeBodyElement>
)