package com.adrienmandroid.composecv.core.ui.states

sealed interface PageState<out T> {
    data class Content<out T>(val value: T) : PageState<T>
    object Loading : PageState<Nothing>

    object Error: PageState<Nothing>
}
