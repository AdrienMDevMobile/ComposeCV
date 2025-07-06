package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.VersionName

interface VersionNameRepository {
    fun getAppVersionName(): VersionName
}