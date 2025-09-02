package com.adrienmandroid.composecv.feature.skills.data.remote

import android.content.Context
import android.util.Log
import com.adrienmandroid.composecv.data.remote.DataProviderJSON
import com.adrienmandroid.composecv.feature.skills.data.converter.toDomain
import com.adrienmandroid.composecv.feature.skills.data.remote.Skill as SkillData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import com.adrienmandroid.composecv.feature.skills.data.SkillRemoteDataSource
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SkillRemoteDataSourceJsonImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SkillRemoteDataSource {
    @OptIn(ExperimentalStdlibApi::class)
    override fun getData(): List<Skill> {
        val json: String? = DataProviderJSON(FILE_NAME).loadJSONFromAsset(context)

        if(json == null){
            Log.e("jsonError", "SkillJsonProvider returned null")
            return emptyList()
        } else {

            val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<Array<SkillData>> = moshi.adapter<Array<SkillData>>()

            return jsonAdapter.fromJson(json)?.toList()?.map { skill -> skill.toDomain() } ?: emptyList()
        }
    }

    companion object {
        private const val FILE_NAME = "skills.json"
    }
}