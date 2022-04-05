package com.adrienmandroid.composecv.data

import androidx.compose.ui.text.TextStyle
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.theme.Typography
import com.adrienmandroid.composecv.ui.welcome.*

fun listOfItemInBottomSheet(): List<SimpleDraw> {
    return listOf(
        TextDraw(id = R.string.names, style = Typography.h4),
        TextDraw(id = R.string.title, style = Typography.h6),
        TextDraw(id = R.string.age, args = arrayOf(26)),
        TextDraw(iconId = R.drawable.email, id = R.string.emailAdress),
        TextDraw(iconId = R.drawable.location, id = R.string.adress),
        TextDraw(iconId = R.drawable.github, id = R.string.gitHub),
        TextDraw(iconId = R.drawable.linkedin, id = R.string.linkedIn),
        QuoteTextDraw(id = R.string.selfPresentation),
        ImageDraw(R.drawable.auboulotavelo, "Au boult à velo"),
        KeywordsDraw(arrayOf("Android", "Kotlin", "Jetpack compose", "Growth mindset", "Creativité"))
    )
}