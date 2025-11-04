package com.adrienmandroid.composecv.feature.data

import android.content.Context
import com.adrienmandroid.composecv.feature.welcome.data.R
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date
import javax.inject.Inject

class WelcomeElementsRepositoryImpl @Inject constructor(
    val remoteDataSource: WelcomeRemoteDataSource
) : WelcomeElementsRepository {

    override fun get(coroutineScope: CoroutineScope): Flow<Response<WelcomeHeader, WelcomeBodyElement>> {
        return flow {
            emit(remoteDataSource.getData())
        }
    }
}

class OldWelcomeElementsRepositoryImpl(
    private val context: Context,
) : WelcomeElementsRepository {

    override fun get(coroutineScope: CoroutineScope): Flow<Response<WelcomeHeader, WelcomeBodyElement>> {
        return flow {
            emit(
                listOf(
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
                    WelcomeBodyElement.WelcomeKeywordList(
                        listOf(
                            Keyword(context.getString(R.string.kw_android)),
                            Keyword(context.getString(R.string.kw_kotlin)),
                            Keyword(context.getString(R.string.kw_compose)),
                            Keyword(context.getString(R.string.kw_growth)),
                            Keyword(context.getString(R.string.kw_creativity))
                        )
                    )
                ).toResponse(
                    WelcomeHeader(
                        profilePictureUrl = "https://i.imgur.com/Bx3Cl0T.jpeg",
                        backgroundPictureUrl = "https://i.imgur.com/HR6QyAW.jpeg",
                    )
                )
            )
        }
    }
}