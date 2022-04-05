package com.adrienmandroid.composecv.ui.experience

class Experience(
    val name : String,
    val logo : Int,
    val link : Link? = null,
    val ExpDates : ExpDates,
    val informations : List<String>
)