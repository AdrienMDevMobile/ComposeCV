package com.adrienmandroid.composecv.ui.nav.intents

class MailClickable(private val address: String) : IClickable {
    override fun onClick(viewModel: ClickViewModel) {
        viewModel.onMailClick(address)
    }
}