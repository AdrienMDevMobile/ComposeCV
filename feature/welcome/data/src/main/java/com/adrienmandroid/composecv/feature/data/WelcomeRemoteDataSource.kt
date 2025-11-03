package com.adrienmandroid.composecv.feature.data

import com.adrienmandroid.composecv.data.ResponseRemoteDataSource
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader

interface WelcomeRemoteDataSource : ResponseRemoteDataSource<WelcomeHeader, WelcomeBodyElement>