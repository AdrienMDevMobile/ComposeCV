package com.adrienmandroid.composecv.feature.other.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.model.Hobby

abstract class OtherViewModel: ViewModel() {
    abstract val hobbies: LiveData<List<Hobby>>
}