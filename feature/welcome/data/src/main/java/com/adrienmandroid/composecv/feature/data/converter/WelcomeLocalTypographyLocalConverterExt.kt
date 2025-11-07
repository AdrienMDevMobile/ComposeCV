package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.local.TypographyLocalEntity
import com.adrienmandroid.composecv.model.TypographyEnum

fun TypographyLocalEntity.toDomain() = when (this) {
    TypographyLocalEntity.H1 -> TypographyEnum.H1
    TypographyLocalEntity.H2 -> TypographyEnum.H2
    TypographyLocalEntity.H3 -> TypographyEnum.H3
    TypographyLocalEntity.H4 -> TypographyEnum.H4
    TypographyLocalEntity.H5 -> TypographyEnum.H5
    TypographyLocalEntity.H6 -> TypographyEnum.H6
    TypographyLocalEntity.SUBTITLE1 -> TypographyEnum.SUBTITLE1
    TypographyLocalEntity.SUBTITLE2 -> TypographyEnum.SUBTITLE2
    TypographyLocalEntity.BODY1 -> TypographyEnum.BODY1
    TypographyLocalEntity.BODY2 -> TypographyEnum.BODY2
    TypographyLocalEntity.BODY1BOLD -> TypographyEnum.BODY1BOLD
    TypographyLocalEntity.BUTTON -> TypographyEnum.BUTTON
    TypographyLocalEntity.CAPTION -> TypographyEnum.CAPTION
    TypographyLocalEntity.OVERLINE -> TypographyEnum.OVERLINE
}

fun TypographyEnum.toLocalEntity() = when (this) {
    TypographyEnum.H1 -> TypographyLocalEntity.H1
    TypographyEnum.H2 -> TypographyLocalEntity.H2
    TypographyEnum.H3 -> TypographyLocalEntity.H3
    TypographyEnum.H4 -> TypographyLocalEntity.H4
    TypographyEnum.H5 -> TypographyLocalEntity.H5
    TypographyEnum.H6 -> TypographyLocalEntity.H6
    TypographyEnum.SUBTITLE1 -> TypographyLocalEntity.SUBTITLE1
    TypographyEnum.SUBTITLE2 -> TypographyLocalEntity.SUBTITLE2
    TypographyEnum.BODY1 -> TypographyLocalEntity.BODY1
    TypographyEnum.BODY2 -> TypographyLocalEntity.BODY2
    TypographyEnum.BODY1BOLD -> TypographyLocalEntity.BODY1BOLD
    TypographyEnum.BUTTON -> TypographyLocalEntity.BUTTON
    TypographyEnum.CAPTION -> TypographyLocalEntity.CAPTION
    TypographyEnum.OVERLINE -> TypographyLocalEntity.OVERLINE
}