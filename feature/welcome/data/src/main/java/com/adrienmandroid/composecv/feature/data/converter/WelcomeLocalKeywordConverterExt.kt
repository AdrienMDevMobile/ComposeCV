package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword

fun toListString(list: List<Keyword>): String {
    return list.joinToString(",") { it.value }
}

fun fromListString(data: String): List<Keyword> {
    return listOf(*data.split(",").map { Keyword(it) }.toTypedArray())
}