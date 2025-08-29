package com.adrienmandroid.composecv.feature.skills.data.remote

import android.content.Context
import com.adrienmandroid.composecv.data.remote.DataProviderJSON

class SkillJsonProvider(context: Context) : DataProviderJSON(context) {
    override val fileName = "skills.json"
}