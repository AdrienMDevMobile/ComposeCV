package com.adrienmandroid.composecv.data.local

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.zip.DataFormatException

val FORMATTER = SimpleDateFormat("yyy-MM-dd", Locale.FRANCE)

fun Date.toRoomString(): String = FORMATTER.format(this)

fun String.toJavaDate() = FORMATTER.parse(this) ?: throw DataFormatException("Unhandled date $this")