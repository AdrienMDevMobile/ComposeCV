package com.adrienmandroid.composecv.feature.experience.data.remote

import android.content.Context
import android.util.Log
import com.adrienmandroid.composecv.feature.experience.data.ExperienceRemoteDataSource
import com.adrienmandroid.composecv.feature.experience.data.converter.toDomain
import com.adrienmandroid.composecv.feature.experience.data.remote.Experience as ExperienceData
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ExperienceRemoteDataSourceJsonImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ExperienceRemoteDataSource {
    @OptIn(ExperimentalStdlibApi::class)
    override fun getData(): List<Experience> {
        val json: String? = ExperienceJsonProvider(context).loadJSONFromAsset()

        if(json == null){
            Log.e("jsonError", "ExperienceJsonProvider returned null")
            return emptyList()
        } else {

            val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<Array<ExperienceData>> = moshi.adapter<Array<ExperienceData>>()

            return jsonAdapter.fromJson(json)?.toList()?.map { experience -> experience.toDomain() } ?: emptyList()
        }
    }
}