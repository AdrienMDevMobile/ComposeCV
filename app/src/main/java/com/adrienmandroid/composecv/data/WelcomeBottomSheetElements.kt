package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.welcome.ImageDraw
import com.adrienmandroid.composecv.ui.welcome.QuoteTextDraw
import com.adrienmandroid.composecv.ui.welcome.SimpleDraw
import com.adrienmandroid.composecv.ui.welcome.TextDraw

fun listOfItemInBottomSheet(): List<SimpleDraw> {
    return listOf(
        TextDraw(id = R.string.names),
        TextDraw(id = R.string.title),
        TextDraw(id = R.string.age, arrayOf(26)),
        TextDraw(id = R.string.emailAdress),
        QuoteTextDraw(id = R.string.selfPresentation),
        ImageDraw(R.drawable.auboulotavelo, "Au boult à velo")

    )
}