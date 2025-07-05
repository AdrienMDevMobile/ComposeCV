package com.adrienmandroid.composecv.data.impl

import android.content.Context
import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.data.WelcomeElementsRepository
import com.adrienmandroid.composecv.model.Clickable
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.WelcomeBodyElement
import com.adrienmandroid.composecv.model.WelcomeHeader
import com.adrienmandroid.composecv.model.WelcomePage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WelcomeElementsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : WelcomeElementsRepository {

    override fun getWelcomePageElements(): WelcomePage {
        return WelcomePage(
            header = WelcomeHeader(
                profilePicture = R.drawable.profile_picture,
                backgroundPicture = R.drawable.background_picture,
            ),
            body = listOf(
                WelcomeBodyElement.WelcomeText(value = context.getString(R.string.names), style = TypographyEnum.H4),
                WelcomeBodyElement.WelcomeText(value = context.getString(R.string.title), style = TypographyEnum.H5),
                WelcomeBodyElement.WelcomeText(
                    value = context.getString(R.string.age, 27),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.email,
                    value = context.getString(R.string.emailAdress),
                    clickable = Clickable.MailClick(R.string.emailAdress),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.location,
                    value = context.getString(R.string.adress),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.github,
                    value = context.getString(R.string.gitHub),
                    clickable = Clickable.WebClick(R.string.gitHubLink),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.linkedin,
                    value = context.getString(R.string.linkedIn),
                    clickable = Clickable.WebClick(R.string.linkedInLink),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeQuote(id = R.string.selfPresentation),
                WelcomeBodyElement.WelcomeImage(
                    R.drawable.auboulotavelo,
                    "Au boulot à velo",
                    tint = true
                ),
                WelcomeBodyElement.WelcomeText(
                    value = context.getString(R.string.Welcome_Keywords),
                    style = TypographyEnum.BODY1BOLD
                ),
                WelcomeBodyElement.WelcomeKeyword(
                    arrayOf(
                        com.adrienmandroid.composecv.model.Keyword(context.getString(R.string.kw_android)),
                        com.adrienmandroid.composecv.model.Keyword(context.getString(R.string.kw_kotlin)),
                        com.adrienmandroid.composecv.model.Keyword(context.getString(R.string.kw_compose)),
                        com.adrienmandroid.composecv.model.Keyword(context.getString(R.string.kw_growth)),
                        com.adrienmandroid.composecv.model.Keyword(context.getString(R.string.kw_creativity))
                    )
                )
            )
        )
    }
}