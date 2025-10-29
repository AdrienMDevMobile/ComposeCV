package com.adrienmandroid.composecv.feature.experience.data

import com.adrienmandroid.composecv.data.ResponseRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience

interface ExperienceRemoteDataSource : ResponseRemoteDataSource<Unit, Experience>