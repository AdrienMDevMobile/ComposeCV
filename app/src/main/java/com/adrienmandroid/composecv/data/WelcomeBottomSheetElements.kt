package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.welcome.ImageDraw
import com.adrienmandroid.composecv.ui.welcome.SimpleDrawable
import com.adrienmandroid.composecv.ui.welcome.TextDraw

fun listOfItemInBottomSheet(): List<SimpleDrawable> {
    return listOf(
        TextDraw(id = R.string.names),
        TextDraw(id = R.string.title),
        TextDraw(id = R.string.age, arrayOf(26)),
        TextDraw(id = R.string.emailAdress),
        TextDraw(id = R.string.selfPresentation),
        ImageDraw(R.drawable.auboulotavelo, "Au boult à velo")

    )
}