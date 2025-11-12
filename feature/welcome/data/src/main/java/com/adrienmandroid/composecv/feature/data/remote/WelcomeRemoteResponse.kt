package com.adrienmandroid.composecv.feature.data.remote

data class WelcomeRemoteResponse(
    val header: WelcomeRemoteResponseHeader,
    val body: List<WelcomeRemoteBodyElement>
)