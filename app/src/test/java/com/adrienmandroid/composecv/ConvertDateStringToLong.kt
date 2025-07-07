package com.adrienmandroid.composecv

import java.text.SimpleDateFormat
import java.util.Locale

fun String.toTestLong(): Long? =
    SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE).parse(this)?.time