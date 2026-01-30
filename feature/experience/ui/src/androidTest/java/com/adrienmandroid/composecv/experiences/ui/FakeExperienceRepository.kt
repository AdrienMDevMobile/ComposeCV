package com.adrienmandroid.composecv.experiences.ui

import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class FakeExperienceRepository : ExperienceRepository {
    override fun get(): Flow<BasicResponse<Experience>> = flow {
        emit(
            listOf(
                Experience(
                    name = "Experience 1",
                    employer = "Employer 1",
                    logoUrl = "",
                    expDates = Dates(Date(), null),
                    professional = true,
                    informations = listOf(
                        ExperienceInformation(
                            "no end date"
                        ),
                        ExperienceInformation(
                            "is professionnal"
                        ),
                        ExperienceInformation(
                            "Text 1"
                        ),
                        ExperienceInformation(
                            "Line 1 \nLine 2 \nLine 3"
                        )
                    )
                ),
                Experience(
                    name = "Experience 2",
                    employer = "Employer 2",
                    logoUrl = "",
                    expDates = Dates(Date(), Date()),
                    professional = true,
                    informations = listOf(
                        ExperienceInformation(
                            "has end date"
                        ),
                        ExperienceInformation(
                            "not professionnal"
                        ),
                        ExperienceInformation(
                            "Text 1"
                        ),
                        ExperienceInformation(
                            "Line 1 \nLine 2 \nLine 3"
                        )
                    )
                ),
                Experience(
                    name = "Experience 3",
                    employer = "Employer 3",
                    logoUrl = "",
                    expDates = Dates(Date(), Date()),
                    professional = true,
                    informations = listOf(
                        ExperienceInformation(
                            "no end date"
                        ),
                        ExperienceInformation(
                            "not professionnal"
                        ),
                        ExperienceInformation(
                            "Text 1"
                        ),
                        ExperienceInformation(
                            "Line 1 \nLine 2 \nLine 3"
                        )
                    )
                ),
            ).toResponse()
        )
    }
}