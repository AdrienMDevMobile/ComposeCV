package com.adrienmandroid.composecv.data.remote

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val mContext: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        if (!this.isOnline) {
            throw NoConnectivityException()
        }

        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    val isOnline: Boolean
        @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
        get() {
            val connectivityManager =
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            return (netCapabilities != null
                    // indicates that the network is set up to access the internet
                    && netCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    // indicates that the network provides actual access to the public internet when it is probed
                    && netCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED))
        }
}

