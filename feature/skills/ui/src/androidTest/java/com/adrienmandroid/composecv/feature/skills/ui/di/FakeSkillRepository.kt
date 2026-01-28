package com.adrienmandroid.composecv.feature.skills.ui.di

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSkillRepository(
    val showAll: Boolean = true
) : SkillRepository {
    override fun get(): Flow<BasicResponse<Skill>> = flow {
        if (showAll) {
            emit(
                listOf(
                    Skill(
                        name = "Skill 1 value",
                        targetValue = 0.7f,
                        explanation = "Explanation 1"
                    ),
                    Skill(
                        name = "Skill 2 subskills",
                        subSkills = Pair("Subskill 1", "Subskill 2"),
                        explanation = "Explanation 2"
                    )
                ).toResponse()
            )
        } else {
            emit(
                listOf(
                    Skill(
                        name = "Skill 1 value",
                        targetValue = 0.7f,
                        explanation = "Explanation 1"
                    )
                ).toResponse()
            )
        }
    }
}