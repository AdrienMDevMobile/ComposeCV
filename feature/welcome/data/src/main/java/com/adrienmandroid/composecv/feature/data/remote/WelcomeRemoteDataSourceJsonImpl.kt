package com.adrienmandroid.composecv.feature.data.remote

import android.content.Context
import android.util.Log
import com.adrienmandroid.composecv.data.remote.DataProviderJSON
import com.adrienmandroid.composecv.feature.data.WelcomeRemoteDataSource
import com.adrienmandroid.composecv.feature.data.converter.toDomain
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.response.Response
import com.adrienmandroid.composecv.model.response.toResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WelcomeRemoteDataSourceJsonImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : WelcomeRemoteDataSource {
    @OptIn(ExperimentalStdlibApi::class)
    override fun getData(): Response<WelcomeHeader, WelcomeBodyElement> {
        val json: String? = DataProviderJSON(FILE_NAME).loadJSONFromAsset(context)

        if (json == null) {
            Log.e("jsonError", "SkillJsonProvider returned null")
            return emptyList<WelcomeBodyElement>().toResponse(WelcomeHeader("", ""))
        } else {

            val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<WelcomeRemoteResponse> =
                moshi.adapter<WelcomeRemoteResponse>()

            val response = jsonAdapter.fromJson(json)

            return (response?.body?.toList()
                ?.mapNotNull { element -> element.toDomain() }
                ?: emptyList()).toResponse(
                //TODO null safety
                response?.header?.toDomain() ?: WelcomeHeader("", "")
            )
        }
    }

    companion object {
        private const val FILE_NAME = "welcome.json"
    }
}