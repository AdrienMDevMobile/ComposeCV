package com.adrienmandroid.composecv.feature.other.data.local

import androidx.room.RoomDatabase
import com.adrienmandroid.composecv.feature.other.data.OtherLocalDataSource
import com.adrienmandroid.composecv.feature.other.data.converter.toDomain
import com.adrienmandroid.composecv.feature.other.data.converter.toLocalEntity
import com.adrienmandroid.composecv.feature.other.data.local.dao.GratitudeDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.HobbyDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.QuoteDao
import com.adrienmandroid.composecv.feature.other.data.local.dao.StudyDao
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.model.response.BasicResponse
import com.adrienmandroid.composecv.model.response.toResponse
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OtherLocalDataSourceRoomImpl @Inject constructor(
    private val hobbyDao: HobbyDao,
    private val quoteDao: QuoteDao,
    private val studyDao: StudyDao,
    private val gratitudeDao: GratitudeDao,
    private val database: RoomDatabase,
) : OtherLocalDataSource {
    override fun saveData(data: BasicResponse<OtherComponent>) {
        database.runInTransaction {

            data.page.forEach { component ->
                when (component) {
                    is OtherComponent.Hobbies -> hobbyDao.insertAll(*component.hobbies.map { it.toLocalEntity() }
                        .toTypedArray())

                    is OtherComponent.Quotes -> quoteDao.insertAll(*component.quotes.map { it.toLocalEntity() }
                        .toTypedArray())

                    is OtherComponent.Studies -> studyDao.insertAll(*component.studies.map { it.toLocalEntity() }
                        .toTypedArray())

                    is OtherComponent.Gratitudes -> gratitudeDao.insertAll(*component.value.map { it.toLocalEntity() }
                        .toTypedArray())

                    is OtherComponent.Version -> {
                        /* Versions aren't saved in database */
                    }

                    OtherComponent.Signature -> {
                        /* Signature aren't saved in database */
                    }
                }
            }
        }
    }

    @OptIn(FlowPreview::class)
    override fun getData(): Flow<BasicResponse<OtherComponent>> {
        val flowHobby = hobbyDao.getAllAsFlow().map { hobbies ->
            if (hobbies.isNotEmpty()) {
                OtherComponent.Hobbies(hobbies.map { it.toDomain() })
            } else null
        }
        val flowQuote = quoteDao.getAllAsFlow().map { quotes ->
            if (quotes.isNotEmpty()) {
                OtherComponent.Quotes(quotes.map { it.toDomain() })
            } else null
        }
        val flowStudy = studyDao.getAllAsFlow().map { studies ->
            if (studies.isNotEmpty()) {
                OtherComponent.Studies(studies.map { it.toDomain() })
            } else null
        }
        val flowGratitude = gratitudeDao.getAllAsFlow().map { gratitudes ->
            if (gratitudes.isNotEmpty()) {
                OtherComponent.Gratitudes(gratitudes.map { it.toDomain() })
            } else null
        }

        return combine(
            flowHobby,
            flowQuote,
            flowStudy,
            flowGratitude
        ) { hobbies, quotes, studies, gratitudes ->
            mutableListOf<OtherComponent>().apply {
                if (studies != null) add(studies)
                if (quotes != null) add(quotes)
                if (hobbies != null) add(hobbies)
                if (gratitudes != null) add(gratitudes)
            }.toResponse()
        }
            .debounce(500)
    }

}