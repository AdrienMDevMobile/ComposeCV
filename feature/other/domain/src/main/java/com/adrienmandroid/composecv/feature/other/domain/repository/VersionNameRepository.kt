package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.VersionName

interface VersionNameRepository {
    fun getAppVersionName(): VersionName
}