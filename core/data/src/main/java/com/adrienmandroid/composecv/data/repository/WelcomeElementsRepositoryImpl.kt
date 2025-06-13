package com.adrienmandroid.composecv.data.repository

import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.model.Clickable
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.WelcomeElement

class WelcomeElementsRepositoryImpl : WelcomeElementsRepository {

    override fun listOfWelcomeItems(): List<WelcomeElement> {
        return listOf(
            WelcomeElement.WelcomeText(id = R.string.names, style = TypographyEnum.H4),
            WelcomeElement.WelcomeText(id = R.string.title, style = TypographyEnum.H5),
            WelcomeElement.WelcomeText(
                id = R.string.age,
                args = arrayOf(27),
                style = TypographyEnum.BODY1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.email,
                id = R.string.emailAdress,
                clickable = Clickable.MailClick(R.string.emailAdress),
                style = TypographyEnum.BODY1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.location,
                id = R.string.adress,
                style = TypographyEnum.BODY1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.github,
                id = R.string.gitHub,
                clickable = Clickable.WebClick(R.string.gitHubLink),
                style = TypographyEnum.BODY1
            ),
            WelcomeElement.WelcomeText(
                iconId = R.drawable.linkedin,
                id = R.string.linkedIn,
                clickable = Clickable.WebClick(R.string.linkedInLink),
                style = TypographyEnum.BODY1
            ),
            WelcomeElement.WelcomeQuote(id = R.string.selfPresentation),
            WelcomeElement.WelcomeImage(R.drawable.auboulotavelo, "Au boulot à velo", tint = true),
            WelcomeElement.WelcomeText(
                id = R.string.Welcome_Keywords,
                style = TypographyEnum.BODY1BOLD
            ),
            WelcomeElement.WelcomeKeyword(
                arrayOf(
                    com.adrienmandroid.composecv.model.Keyword(R.string.kw_android),
                    com.adrienmandroid.composecv.model.Keyword(R.string.kw_kotlin),
                    com.adrienmandroid.composecv.model.Keyword(R.string.kw_compose),
                    com.adrienmandroid.composecv.model.Keyword(R.string.kw_growth),
                    com.adrienmandroid.composecv.model.Keyword(R.string.kw_creativity)
                )
            )
        )
    }
}