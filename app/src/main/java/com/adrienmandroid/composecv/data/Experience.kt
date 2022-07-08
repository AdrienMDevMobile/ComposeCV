package com.adrienmandroid.composecv.data

class Experience(
    val name : String,
    val employer : String? = null,
    val logo : Int,
    val link : Link? = null,
    val ExpDates : Dates,
    val informations : List<String>
)