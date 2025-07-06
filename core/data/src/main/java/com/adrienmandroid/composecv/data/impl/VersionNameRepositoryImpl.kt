package com.adrienmandroid.composecv.data.impl

import android.os.Build
import com.adrienmandroid.composecv.data.VersionNameRepository
import javax.inject.Inject

class VersionNameRepositoryImpl @Inject constructor()
    : VersionNameRepository {
    override fun getAppVersionName(): String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Build.VERSION.RELEASE_OR_CODENAME
    } else {
        Build.VERSION.RELEASE
    }
}