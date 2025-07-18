package com.adrienmandroid.composecv.feature.other

import android.content.Context
import com.adrienmandroid.composecv.feature.other.data.R
import com.adrienmandroid.composecv.feature.other.domain.repository.GratitudeRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GratitudeRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : GratitudeRepository {
    override fun getGratitude(): String = context.getString(R.string.txt_gratitude)
}