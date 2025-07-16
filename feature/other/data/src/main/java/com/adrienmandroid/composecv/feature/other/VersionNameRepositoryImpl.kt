package com.adrienmandroid.composecv.feature.other

import android.os.Build
import com.adrienmandroid.composecv.feature.other.domain.repository.VersionNameRepository
import javax.inject.Inject

class VersionNameRepositoryImpl @Inject constructor()
    : VersionNameRepository {
    override fun getAppVersionName(): String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Build.VERSION.RELEASE_OR_CODENAME
    } else {
        Build.VERSION.RELEASE
    }
}