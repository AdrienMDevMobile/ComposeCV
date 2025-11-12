package com.adrienmandroid.composecv.feature.data

import com.adrienmandroid.composecv.data.ResponseLocalDataSource
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader

interface WelcomeLocalDataSource : ResponseLocalDataSource<WelcomeHeader, WelcomeBodyElement>