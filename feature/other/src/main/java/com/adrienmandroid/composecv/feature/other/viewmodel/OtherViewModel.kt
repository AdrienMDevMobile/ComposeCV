package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.data.GratitudeRepository
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.QuoteRepository
import com.adrienmandroid.composecv.data.StudyRepository
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.model.Quote
import com.adrienmandroid.composecv.model.Study
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    studyRepository: StudyRepository,
    quoteRepository: QuoteRepository,
    hobbyRepository: HobbyRepository,
    gratitudeRepository: GratitudeRepository,
    //versionRepository: VersionRepository,
) : ViewModel() {

    //TODO WTF ???
    private val _studies = MutableLiveData<List<Study>>(emptyList())
    val studies = _studies

    private val _quotes = MutableLiveData<List<Quote>>(emptyList())
    val quotes = _quotes

    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    val hobbies = _hobbies

    private val _gratitude = MutableLiveData<String>()
    val gratitude = _gratitude

    init {
        _studies.value = studyRepository.getData()
        _quotes.value = quoteRepository.getQuotes()
        _hobbies.value = hobbyRepository.getHobbies()
        _gratitude.value = gratitudeRepository.getGratitude()
    }
}