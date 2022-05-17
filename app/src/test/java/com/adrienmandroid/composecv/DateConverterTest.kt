package com.adrienmandroid.composecv

import com.adrienmandroid.composecv.ui.experience.toDayString
import com.adrienmandroid.composecv.ui.experience.toMyLong
import com.adrienmandroid.composecv.ui.experience.toMonthString
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class DateConverterTest {
    /*
    @Test
    fun dayStringIsCorrect() {
        assertEquals("10 mai 1995", Date(800112600000).toDayString())
    }
    @Test
    fun monthStringIsCorrect() {
        assertEquals("mai 1995", Date(800112600000).toMonthString())
    } */

    @Test
    fun testingDateInLong(){
        assertEquals("","1 juillet 2020".toMyLong())

    }

    @Test
    fun testingDateInLong3(){
        assertEquals("","8 janvier 2022".toMyLong())

    }


    @Test
    fun testingDateInLong4(){
        assertEquals("","17 février 2022".toMyLong())
    }

    /*
    @Test
    fun testingDateInLong6(){
        assertEquals("","1 juin 2019".toMyLong())
    }*/

}