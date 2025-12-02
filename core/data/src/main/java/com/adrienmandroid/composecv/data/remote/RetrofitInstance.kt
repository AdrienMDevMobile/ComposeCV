package com.adrienmandroid.composecv.data.remote

import android.content.Context
import com.adrienmandroid.composecv.data.remote.ApiConstant.Companion.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitInstance {
    private val json = Json { ignoreUnknownKeys = true }

    fun createInstance(context: Context): Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(NetworkConnectionInterceptor(mContext = context))
                .build()
        )
        .build()
}