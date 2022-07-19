package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Hobby
import com.adrienmandroid.composecv.data.dataSource.HobbyDataSource

class HobbyDataSourceImpl: HobbyDataSource {
    override fun getHobbies() = listOf(
        Hobby(
            R.string.hobby_LoL,
            R.drawable.hobby_lol,
            R.string.hobby_category_competition
        ),
        Hobby(
            R.string.hobby_wcs,
            R.drawable.hobby_westcoastswing,
            R.string.danse
        ),
        Hobby(
            R.string.hobby_bike,
            R.drawable.hobby_velo,
            R.string.hobby_category_health
        ),
        Hobby(
            R.string.hobby_meditation,
            R.drawable.hobby_meditation,
            R.string.hobby_category_health
        ),
        Hobby(
            R.string.hobby_swim,
            R.drawable.hobby_piscine,
            R.string.hobby_category_health
        ),
        Hobby(
            R.string.hobby_FDC,
            R.drawable.hobby_fdc,
            R.string.hobby_sensibilitation
        )
    )
}