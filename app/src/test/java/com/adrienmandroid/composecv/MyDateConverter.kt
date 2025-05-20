package com.adrienmandroid.composecv

import com.adrienmandroid.composecv.core.ui.toMyLong
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class MyDateConverter {

    @Test
    fun testingDateInLong() {
        assertEquals("", "2 January 2023".toMyLong())

    }

    @Test
    fun testingDateInLong3() {
        assertEquals("", "8 janvier 2022".toMyLong())

    }


    @Test
    fun testingDateInLong4() {
        assertEquals("", "17 février 2022".toMyLong())
    }

    @Test
    fun testDiv(){
        assertEquals("", kotlin.math.abs(Date(1593554400000).time - Date(1641596400000).time))
    }

    @Test
    fun testDiv2(){
        assertEquals(556, (48042000000 / (24 * 60 * 60 * 1000)).toInt())
    }

    @Test
    fun testDiv3(){
        assertEquals(1, 556/365 )
    }


    @Test
    fun testDiv4(){
        assertEquals(6, (556%365)/31 )
    }

    @Test
    fun testDiv5(){
        assertEquals("", "".plus(1).plus("years"))
    }
    /*
    @Test
    fun testingDateInLong6(){
        assertEquals("","1 juin 2019".toMyLong())
    }*/

}