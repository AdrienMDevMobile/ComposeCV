package com.adrienmandroid.composecv.feature.skills.data.remote

import android.content.Context
import android.util.Log
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRemoteRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SkillRemoteRepositoryJsonImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SkillRemoteRepository {

    @OptIn(ExperimentalStdlibApi::class)
    override fun getSkills(): List<Skill> {
        val json: String? = SkillJsonProvider(context).loadJSONFromAsset()

        if(json == null){
            Log.e("jsonError", "SkillJsonProvider returned null")
            return emptyList()
        } else {

            val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<Skills> = moshi.adapter<Skills>()

            return jsonAdapter.fromJson(json)?.skills?.map { skill -> skill.toDomain() } ?: emptyList()
        }
    }
}