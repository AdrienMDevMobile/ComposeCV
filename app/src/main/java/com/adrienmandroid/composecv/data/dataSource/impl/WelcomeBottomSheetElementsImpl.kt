package com.adrienmandroid.composecv.data.dataSource.impl

import androidx.compose.ui.text.font.FontWeight
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Clickable
import com.adrienmandroid.composecv.data.Keyword
import com.adrienmandroid.composecv.data.dataSource.WelcomeBottomSheetElements
import com.adrienmandroid.composecv.data.dataSource.WelcomeElement
import com.adrienmandroid.composecv.ui.theme.Typography

class WelcomeBottomSheetElementsImpl : WelcomeBottomSheetElements {

    override fun listOfItemInBottomSheet(): List<WelcomeElement> {
        return listOf(
            WelcomeElement.WelcomeText(id = R.string.names, style = Typography.h4),
            WelcomeElement.WelcomeText(id = R.string.title, style = Typography.h5),
            WelcomeElement.WelcomeText(
                id = R.string.age,
                args = arrayOf(27),
                style = Typography.body1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.email,
                id = R.string.emailAdress,
                clickable = Clickable.MailClick(R.string.emailAdress),
                style = Typography.body1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.location,
                id = R.string.adress,
                style = Typography.body1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.github,
                id = R.string.gitHub,
                clickable = Clickable.WebClick(R.string.gitHubLink),
                style = Typography.body1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.linkedin,
                id = R.string.linkedIn,
                clickable = Clickable.WebClick(R.string.linkedInLink),
                style = Typography.body1
            ),
            WelcomeElement.WelcomeQuote(id = R.string.selfPresentation),
            WelcomeElement.WelcomeImage(R.drawable.auboulotavelo, "Au boult à velo"),
            WelcomeElement.WelcomeText(
                id = R.string.Welcome_Keywords,
                style = Typography.body1.copy(fontWeight = FontWeight.Bold)
            ),
            WelcomeElement.WelcomeKeyword(
                arrayOf(
                    Keyword(R.string.kw_android),
                    Keyword(R.string.kw_kotlin),
                    Keyword(R.string.kw_compose),
                    Keyword(R.string.kw_growth),
                    Keyword(R.string.kw_creativity)
                )
            )
        )
    }
}