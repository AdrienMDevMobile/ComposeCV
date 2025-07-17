package com.adrienmandroid.composecv.feature.data

import android.content.Context
import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomePage
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import javax.inject.Inject

class WelcomeElementsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository {

    override fun getWelcomePageElements(): WelcomePage {
        return WelcomePage(
            header = WelcomeHeader(
                profilePictureUrl = "https://drive.google.com/file/d/1SsHO3yi3FnHgM82rJUrYhJxqHieNktVH/view?usp=drive_link",
                backgroundPictureUrl = "https://i.imgur.com/HR6QyAW.jpeg",
            ),
            body = listOf(
                WelcomeBodyElement.WelcomeText(
                    value = context.getString(R.string.names),
                    style = TypographyEnum.H4
                ),
                WelcomeBodyElement.WelcomeText(
                    value = context.getString(R.string.title),
                    style = TypographyEnum.H5
                ),
                WelcomeBodyElement.BirthdayText(
                    value = Date(800056800000),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.email,
                    value = context.getString(R.string.emailAdress),
                    clickable = Clickable.MailClick(
                        context.getString(R.string.emailAdress)
                    ),
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
                    clickable = Clickable.WebClick(
                        context.getString(R.string.gitHubLink)
                    ),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeText(
                    iconId = R.drawable.linkedin,
                    value = context.getString(R.string.linkedIn),
                    clickable = Clickable.WebClick(
                        context.getString(R.string.linkedInLink)
                    ),
                    style = TypographyEnum.BODY1
                ),
                WelcomeBodyElement.WelcomeQuote(
                    context.getString(R.string.selfPresentation)
                ),
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
                        Keyword(context.getString(R.string.kw_android)),
                        Keyword(context.getString(R.string.kw_kotlin)),
                        Keyword(context.getString(R.string.kw_compose)),
                        Keyword(context.getString(R.string.kw_growth)),
                        Keyword(context.getString(R.string.kw_creativity))
                    )
                )
            )
        )
    }
}