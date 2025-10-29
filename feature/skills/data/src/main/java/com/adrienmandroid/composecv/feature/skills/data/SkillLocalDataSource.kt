package com.adrienmandroid.composecv.feature.skills.data

import com.adrienmandroid.composecv.data.ResponseLocalDataSource
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

interface SkillLocalDataSource : ResponseLocalDataSource<Void, Skill>