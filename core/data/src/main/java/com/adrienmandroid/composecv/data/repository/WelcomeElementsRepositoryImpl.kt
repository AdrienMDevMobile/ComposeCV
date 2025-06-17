package com.adrienmandroid.composecv.data.repository

import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.model.Clickable
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.WelcomeBodyElement
import com.adrienmandroid.composecv.model.WelcomeHeader
import com.adrienmandroid.composecv.model.WelcomePage

class WelcomeElementsRepositoryImpl : WelcomeElementsRepository {

    override fun getWelcomePageElements(): WelcomePage {
        return WelcomePage(
            header = WelcomeHeader(
                profilePicture = R.drawable.profile_picture,
                backgroundPicture = R.drawable.background_picture,
            ),
            body = listOf(
                WelcomeBodyElement.WelcomeText(id = R.string.names, style = TypographyEnum.H4),
                WelcomeBodyElement.WelcomeText(id = R.string.title, style = TypographyEnum.H5),
                WelcomeBodyElement.WelcomeText(
                    id = R.string.age,
                    args = arrayOf(27),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.email,
                    id = R.string.emailAdress,
                    clickable = Clickable.MailClick(R.string.emailAdress),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.location,
                    id = R.string.adress,
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.github,
                    id = R.string.gitHub,
                    clickable = Clickable.WebClick(R.string.gitHubLink),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.linkedin,
                    id = R.string.linkedIn,
                    clickable = Clickable.WebClick(R.string.linkedInLink),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeQuote(id = R.string.selfPresentation),
                WelcomeBodyElement.WelcomeImage(R.drawable.auboulotavelo, "Au boulot à velo", tint = true),
                WelcomeBodyElement.WelcomeText(
                    id = R.string.Welcome_Keywords,
                    style = TypographyEnum.BODY1BOLD
                ),
                WelcomeBodyElement.WelcomeKeyword(
                    arrayOf(
                        com.adrienmandroid.composecv.model.Keyword(R.string.kw_android),
                        com.adrienmandroid.composecv.model.Keyword(R.string.kw_kotlin),
                        com.adrienmandroid.composecv.model.Keyword(R.string.kw_compose),
                        com.adrienmandroid.composecv.model.Keyword(R.string.kw_growth),
                        com.adrienmandroid.composecv.model.Keyword(R.string.kw_creativity)
                    )
                )
            )
        )
    }
}