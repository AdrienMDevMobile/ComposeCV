package com.adrienmandroid.composecv.model.response

sealed interface Response<H, L> {
    class Success <H, L>(
        val header: H?,
        val page: List<L>
    ): Response<H, L>

    class Error: Response<Unit, Unit>
}