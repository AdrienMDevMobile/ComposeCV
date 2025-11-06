package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.data.local.toJavaDate
import com.adrienmandroid.composecv.data.local.toRoomString
import com.adrienmandroid.composecv.feature.data.converter.WelcomeEntityTypes.BIRTHDAY_TYPE
import com.adrienmandroid.composecv.feature.data.converter.WelcomeEntityTypes.IMAGE_TYPE
import com.adrienmandroid.composecv.feature.data.converter.WelcomeEntityTypes.KEYWORDS_TYPE
import com.adrienmandroid.composecv.feature.data.converter.WelcomeEntityTypes.QUOTE_TYPE
import com.adrienmandroid.composecv.feature.data.converter.WelcomeEntityTypes.TEXT_TYPE
import com.adrienmandroid.composecv.feature.data.local.WelcomeElementEntity
import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement

fun WelcomeBodyElement.toLocalData() = when (this) {
    is WelcomeBodyElement.BirthdayText -> WelcomeElementEntity(
        type = BIRTHDAY_TYPE,
        value = value.toRoomString()
    )

    is WelcomeBodyElement.WelcomeImage -> WelcomeElementEntity(
        type = IMAGE_TYPE,
        //TODO
    )

    is WelcomeBodyElement.WelcomeKeywordList -> WelcomeElementEntity(
        type = KEYWORDS_TYPE,
        value = toListString(keywords)
    )

    is WelcomeBodyElement.WelcomeQuote -> WelcomeElementEntity(
        type = QUOTE_TYPE,
        value = quote
    )

    is WelcomeBodyElement.WelcomeText -> WelcomeElementEntity(
        type = TEXT_TYPE,
        value = value,
        //TODO typography et clickable
    )
}

fun WelcomeElementEntity.toDomain() = when (type) {
    BIRTHDAY_TYPE -> if (value != null)
        WelcomeBodyElement.BirthdayText(value.toJavaDate())
    else null

    IMAGE_TYPE -> TODO()
    KEYWORDS_TYPE -> if (value != null)
        WelcomeBodyElement.WelcomeKeywordList(
            keywords = fromListString(value)
        )
    else null

    QUOTE_TYPE -> if (value != null)
        WelcomeBodyElement.WelcomeQuote(quote = value)
    else null

    TEXT_TYPE -> if (value != null)
        WelcomeBodyElement.WelcomeText(value = value)
    else null

    else -> null
}

fun toListString(list: List<Keyword>): String {
    return list.joinToString(",") { it.value }
}

fun fromListString(data: String): List<Keyword> {
    return listOf(*data.split(",").map { Keyword(it) }.toTypedArray())
}

private object WelcomeEntityTypes {
    const val BIRTHDAY_TYPE = "BIRTHDAY"
    const val IMAGE_TYPE = "IMAGE"
    const val KEYWORDS_TYPE = "KEYWORDS"
    const val QUOTE_TYPE = "QUOTE"
    const val TEXT_TYPE = "TEXT"
}