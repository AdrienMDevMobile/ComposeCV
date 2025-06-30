package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.data.impl.HobbyRepositoryImpl
import com.adrienmandroid.composecv.model.Hobby
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    hobbyRepository: HobbyRepositoryImpl
) : ViewModel() {
    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    val hobbies = _hobbies

    init {
        _hobbies.value = hobbyRepository.getHobbies()
    }
}