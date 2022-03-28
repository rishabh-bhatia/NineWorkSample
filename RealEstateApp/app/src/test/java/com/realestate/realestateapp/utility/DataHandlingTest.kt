package com.realestate.realestateapp.utility

import org.junit.Assert.*
import org.junit.Test

class DataHandlingTest {

    @Test
    fun inserting_double_returns_integer_in_convertDoubleToInt() {
        val response = DataHandling.convertDoubleToInt(9.9)
        if (response is Int) {
            assertTrue("Test Successful", true)
        } else {
            assertTrue("Test Failed", false)
        }
    }

    @Test
    fun inserting_string_double_returns_integer_in_convertStringToInt() {
        val response = DataHandling.convertStringToInt("9.9")
        if (response is Int) {
            assertTrue("Test Successful", true)
        } else {
            assertTrue("Test Failed", false)
        }
    }
}