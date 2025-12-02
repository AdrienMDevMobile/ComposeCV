package com.adrienmandroid.composecv.di

import android.content.Context
import com.adrienmandroid.composecv.data.remote.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit =
        RetrofitInstance.createInstance(context)
}