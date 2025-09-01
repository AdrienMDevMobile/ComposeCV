package com.adrienmandroid.composecv.feature.experience.data.remote

import android.content.Context
import com.adrienmandroid.composecv.data.remote.DataProviderJSON

class ExperienceJsonProvider(context: Context) : DataProviderJSON(context) {
    override val fileName = "experiences.json"
}