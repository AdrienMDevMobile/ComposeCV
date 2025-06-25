package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.MutableLiveData
import com.adrienmandroid.composecv.data.HobbyRepository
import com.adrienmandroid.composecv.data.impl.HobbyRepositoryImpl
import com.adrienmandroid.composecv.model.Hobby
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModelImpl @Inject constructor(
    //TODO utiliser l'interface et passer par un provider
    hobbyRepository: HobbyRepositoryImpl
) : OtherViewModel() {
    private val _hobbies = MutableLiveData<List<Hobby>>(emptyList())
    override val hobbies = _hobbies

    init {
        _hobbies.value = hobbyRepository.getHobbies()
    }
}