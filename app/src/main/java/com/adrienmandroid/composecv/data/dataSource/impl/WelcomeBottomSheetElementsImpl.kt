package com.adrienmandroid.composecv.data.dataSource.impl

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.dataSource.WelcomeBottomSheetElements
import com.adrienmandroid.composecv.ui.nav.intents.MailClickable
import com.adrienmandroid.composecv.ui.nav.intents.WebClickable
import com.adrienmandroid.composecv.ui.theme.Typography
import com.adrienmandroid.composecv.ui.welcome.*

class WelcomeBottomSheetElementsImpl : WelcomeBottomSheetElements {

    override fun listOfItemInBottomSheet(): List<SimpleDraw> {
        return listOf(
            TextDraw(id = R.string.names, style = Typography.h4),
            TextDraw(id = R.string.title, style = Typography.h6),
            TextDraw(id = R.string.age, args = arrayOf(27)),
            TextDraw(
                iconId = R.drawable.email,
                id = R.string.emailAdress,
                clickable = MailClickable("adrienpmichel@gmail.com")
            ),
            TextDraw(iconId = R.drawable.location, id = R.string.adress),
            TextDraw(
                iconId = R.drawable.github,
                id = R.string.gitHub,
                clickable = WebClickable("github.com/AdrienMDevMobile")
            ),
            TextDraw(
                iconId = R.drawable.linkedin,
                id = R.string.linkedIn,
                clickable = WebClickable("www.linkedin.com/in/adrien-michel-android/")
            ),
            QuoteTextDraw(id = R.string.selfPresentation),
            ImageDraw(R.drawable.auboulotavelo, "Au boult à velo"),
            TextDraw(
                id = R.string.Welcome_Keywords,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            ),
            KeywordsDraw(
                arrayOf(
                    "Android",
                    "Kotlin",
                    "Jetpack compose",
                    "Growth mindset",
                    "Créativité"
                )
            )
        )
    }
}