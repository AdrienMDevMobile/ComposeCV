package com.adrienmandroid.composecv.feature.skills.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.liveData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SkillRepository @Inject constructor(
    val remoteRepository: SkillRemoteRepository,
    val localRepository: SkillLocalRepository,
) {
    fun get(coroutineScope: CoroutineScope): LiveData<List<Skill>> = liveData {
        val source = localRepository.getSkills()
            .distinctUntilChanged() // Pour éviter les re-calculs inutiles
        //mediator live data permet d'appliquer la transformation sur notre live data
        emitSource(MediatorLiveData<List<Skill>>().apply {
            //source de notre live data que nous allons modifier.
            addSource(source) { skills ->
                if (skills.isEmpty()) {
                    coroutineScope.launch(Dispatchers.IO) {
                        localRepository.saveSkills(remoteRepository.getSkills())
                    }
                    value = emptyList()
                } else {
                    value = skills
                }
            }
        })
    }
}