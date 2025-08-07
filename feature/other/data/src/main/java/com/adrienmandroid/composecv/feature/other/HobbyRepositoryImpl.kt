package com.adrienmandroid.composecv.feature.other

import android.content.Context
import com.adrienmandroid.composecv.feature.other.data.R
import com.adrienmandroid.composecv.feature.other.domain.model.Hobby
import com.adrienmandroid.composecv.feature.other.domain.repository.HobbyRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HobbyRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
): HobbyRepository {
    override fun getHobbies() = listOf(
        Hobby(
            name = context.getString(R.string.hobby_LoL),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_lol.jpg",
            category = context.getString(R.string.hobby_category_competition)
        ),
        Hobby(
            name =context.getString(R.string.hobby_wcs),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_westcoastswing.jpg",
            category = context.getString(R.string.danse)
        ),
        Hobby(
            name =context.getString(R.string.hobby_bike),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_velo.jpg",
            category = context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            name = context.getString(R.string.hobby_meditation),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_meditation.jpg",
            category = context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            name = context.getString(R.string.hobby_swim),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_piscine.jpg",
            category = context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            name = context.getString(R.string.hobby_FDC),
            pictureUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/hobby/hobby_fdc.jpg",
            category = context.getString(R.string.hobby_sensibilitation)
        )
    )
}