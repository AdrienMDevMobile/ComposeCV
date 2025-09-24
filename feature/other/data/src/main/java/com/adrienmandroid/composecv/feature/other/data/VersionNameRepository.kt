package com.adrienmandroid.composecv.feature.other.data

import android.os.Build
import javax.inject.Inject

class VersionNameRepository @Inject constructor() {
    fun getAppVersionName(): String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Build.VERSION.RELEASE_OR_CODENAME
    } else {
        Build.VERSION.RELEASE
    }
}