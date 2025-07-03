package com.adrienmandroid.composecv.data.impl

import android.content.Context
import com.adrienmandroid.composecv.data.GratitudeRepository
import com.adrienmandroid.composecv.data.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GratitudeRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : GratitudeRepository {
    override fun getGratitude(): String = context.getString(R.string.txt_gratitude)
}