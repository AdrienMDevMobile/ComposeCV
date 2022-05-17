package com.adrienmandroid.composecv.ui.experience

import java.text.SimpleDateFormat
import java.util.*

fun Date.toMonthString() : String = SimpleDateFormat("MMMM yyyy").format(this)
fun Date.toDayString() : String = SimpleDateFormat("dd MMMM yyyy").format(this)


fun String.toMyLong() : Long = SimpleDateFormat("dd MMMM yyyy").parse(this).time