package com.adrienmandroid.composecv.feature.other

import android.content.Context
import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.feature.other.domain.model.Hobby
import com.adrienmandroid.composecv.feature.other.domain.repository.HobbyRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HobbyRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
): HobbyRepository {
    override fun getHobbies() = listOf(
        Hobby(
            context.getString(R.string.hobby_LoL),
            R.drawable.hobby_lol,
            context.getString(R.string.hobby_category_competition)
        ),
        Hobby(
            context.getString(R.string.hobby_wcs),
            R.drawable.hobby_westcoastswing,
            context.getString(R.string.danse)
        ),
        Hobby(
            context.getString(R.string.hobby_bike),
            R.drawable.hobby_velo,
            context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            context.getString(R.string.hobby_meditation),
            R.drawable.hobby_meditation,
            context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            context.getString(R.string.hobby_swim),
            R.drawable.hobby_piscine,
            context.getString(R.string.hobby_category_health)
        ),
        Hobby(
            context.getString(R.string.hobby_FDC),
            R.drawable.hobby_fdc,
            context.getString(R.string.hobby_sensibilitation)
        )
    )
}