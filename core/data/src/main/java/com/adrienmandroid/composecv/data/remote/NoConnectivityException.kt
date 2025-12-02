package com.adrienmandroid.composecv.data.remote

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "Network Connection exception"
}