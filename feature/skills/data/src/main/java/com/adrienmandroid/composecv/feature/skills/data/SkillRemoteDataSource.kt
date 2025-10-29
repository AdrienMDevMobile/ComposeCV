package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.ResponseRemoteDataSource
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

interface SkillRemoteDataSource : ResponseRemoteDataSource<Void, Skill>