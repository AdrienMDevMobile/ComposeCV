package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.StudyRepository
import com.adrienmandroid.composecv.data.impl.HobbyRepositoryImpl
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.model.Study
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    studyRepository: StudyRepository,
    hobbyRepository: HobbyRepository,
) : ViewModel() {

    private val _studies = MutableLiveData<List<Study>>(emptyList())
    val studies = _studies

    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    val hobbies = _hobbies

    init {
        _studies.value = studyRepository.getData()
        _hobbies.value = hobbyRepository.getHobbies()
    }
}