package com.adrienmandroid.composecv.data.remote

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.util.Locale.getDefault

abstract class DataProviderJSON (private val context: Context) {

    protected abstract val file_name: String

    fun loadJSONFromAsset(): String? {
        val file_path : String = file_name.lowercase(getDefault())
        //Log.i("micheldr", "file_path : " + file_path)

        val json = try {
            val assetManager = context.applicationContext.assets
            val stream: InputStream = assetManager.open(file_path)
            val size: Int = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            //Nous renvoyons le string pour json
            String(buffer, Charsets.UTF_8)
        }catch (ex: IOException) {
            //Log.d("micheldr", ex.stackTraceToString())
            ex.printStackTrace()
            return null
        }
        return json

    }
}