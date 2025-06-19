package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.MutableLiveData
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.model.Hobby

class OtherViewModelImpl(
    hobbyRepository: HobbyRepository
) : OtherViewModel() {
    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    override val hobbies = _hobbies

    init {
        _hobbies.value = hobbyRepository.getHobbies()
    }
}