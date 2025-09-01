package com.adrienmandroid.composecv.data.remote

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.util.Locale.getDefault

class DataProviderJSON (private val fileName: String) {

    fun loadJSONFromAsset(context: Context): String? {
        val filePath : String = fileName.lowercase(getDefault())

        val json = try {
            val assetManager = context.applicationContext.assets
            val stream: InputStream = assetManager.open(filePath)
            readJsonStream(stream)
        }catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json

    }

    private fun readJsonStream(stream: InputStream): String {
        val size: Int = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()
        //Nous renvoyons le string pour json
        return String(buffer, Charsets.UTF_8)
    }
}