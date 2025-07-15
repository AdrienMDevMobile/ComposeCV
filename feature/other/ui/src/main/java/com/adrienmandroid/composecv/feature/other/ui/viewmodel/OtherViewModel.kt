package com.adrienmandroid.composecv.feature.other.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.data.GratitudeRepository
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.QuoteRepository
import com.adrienmandroid.composecv.data.StudyRepository
import com.adrienmandroid.composecv.data.VersionNameRepository
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.model.Quote
import com.adrienmandroid.composecv.model.Study
import com.adrienmandroid.composecv.model.VersionName
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    studyRepository: StudyRepository,
    quoteRepository: QuoteRepository,
    hobbyRepository: HobbyRepository,
    gratitudeRepository: GratitudeRepository,
    versionNameRepository: VersionNameRepository,
) : ViewModel() {

    private val _studies = MutableLiveData<List<Study>>(emptyList())
    val studies: LiveData<List<Study>>
        get() = _studies

    private val _quotes = MutableLiveData<List<Quote>>(emptyList())
    val quotes: LiveData<List<Quote>>
        get() = _quotes

    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    val hobbies: LiveData<List<Hobby>>
        get() = _hobbies

    private val _gratitude = MutableLiveData<String>()
    val gratitude: LiveData<String>
        get() = _gratitude

    private val _versionName = MutableLiveData<VersionName>()
    val version: LiveData<VersionName>
        get() = _versionName

    init {
        _studies.value = studyRepository.getData()
        _quotes.value = quoteRepository.getQuotes()
        _hobbies.value = hobbyRepository.getHobbies()
        _gratitude.value = gratitudeRepository.getGratitude()
        _versionName.value = versionNameRepository.getAppVersionName()
    }
}