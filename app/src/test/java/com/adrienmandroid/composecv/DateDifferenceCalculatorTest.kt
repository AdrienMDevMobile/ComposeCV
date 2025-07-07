package com.adrienmandroid.composecv

import com.adrienmandroid.composecv.core.ui.getDifferenceInts
import com.adrienmandroid.composecv.model.Dates
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.util.Date

class DateDifferenceCalculatorTest {

    @Test
    fun testDifferenceOneYear() {
        val begin = "10 mai 1995".toTestLong() ?: 0
        assertNotEquals(0, begin)
        val end = "10 mai 1996".toTestLong() ?: 0
        assertNotEquals(0, end)
        val difference = Dates(Date(begin), Date(end)).getDifferenceInts()
        assertEquals(1, difference.numberYears)
        assertEquals(0, difference.numberMonths)
    }

    @Test
    fun testDifferenceTwoMonths() {
        val begin = "10 mai 1995".toTestLong() ?: 0
        assertNotEquals(0, begin)
        val end = "15 juillet 1995".toTestLong() ?: 0
        assertNotEquals(0, end)
        val difference = Dates(Date(begin), Date(end)).getDifferenceInts()
        assertEquals(0, difference.numberYears)
        assertEquals(2, difference.numberMonths)
    }

    @Test
    fun testDifferenceLessThanAMonth() {
        val difference = Dates(Date(), Date()).getDifferenceInts()
        assertEquals(0, difference.numberYears)
        assertEquals(0, difference.numberMonths)
    }
    /*
        @Test
        fun monthStringIsCorrect() {
            assertEquals("mai 1995", Date(800112600000).toMonthString())
        }
    */
}