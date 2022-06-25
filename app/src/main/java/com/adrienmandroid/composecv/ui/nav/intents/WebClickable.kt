package com.adrienmandroid.composecv.ui.nav.intents

class WebClickable(private val address: String) : IClickable {
    override fun onClick(viewModel: ClickViewModel) {
        viewModel.onWebClick(address)
    }
}