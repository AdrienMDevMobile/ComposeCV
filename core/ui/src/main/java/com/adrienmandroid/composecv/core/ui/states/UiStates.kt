package com.adrienmandroid.composecv.core.ui.states

sealed class UiStates<out T> {
    data class Success<out T>(val value: T) : UiStates<T>()
    //data class Error(val exception: Exception) : UiStates<Nothing>()
    object Loading : UiStates<Nothing>()
}
