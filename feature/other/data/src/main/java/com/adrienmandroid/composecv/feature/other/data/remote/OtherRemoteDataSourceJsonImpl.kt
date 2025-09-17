package com.adrienmandroid.composecv.feature.other.data.remote

import android.content.Context
import android.util.Log
import com.adrienmandroid.composecv.data.remote.DataProviderJSON
import com.adrienmandroid.composecv.feature.other.data.OtherRemoteDataSource
import com.adrienmandroid.composecv.feature.other.data.converter.toDomain
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OtherRemoteDataSourceJsonImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : OtherRemoteDataSource {
    @OptIn(ExperimentalStdlibApi::class)
    override fun getData(): List<OtherComponent> {
        val json: String? = DataProviderJSON(FILE_NAME).loadJSONFromAsset(context)

        if (json == null) {
            Log.e("jsonError", "SkillJsonProvider returned null")
            return emptyList()
        } else {

            val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<OtherJsonBody> = moshi.adapter<OtherJsonBody>()

            return jsonAdapter.fromJson(json)?.let { jsonBody ->
                listOf(
                    OtherComponent.Studies(jsonBody.studies.map { it.toDomain() }),
                    OtherComponent.Hobbies(jsonBody.hobbies.map { it.toDomain() }),
                    OtherComponent.Quotes(jsonBody.quotes.map { it.toDomain() }),
                    //TODO gratitude
                )
            } ?: emptyList()
        }
    }

    companion object {
        private const val FILE_NAME = "others.json"
    }
}