package com.realestate.realestateapp.utility

object DataHandling {

    /**
     * A double element that is converted to an Integer
     *
     * @param
     * @return An Integer
     */
    fun convertDoubleToInt(double: Double): Int {
        return double.toInt()
    }

    /**
     * A double element that is passed as a string is converted to an Integer
     *
     * @param string A nullable string which is expected to be a double
     * @return An Integer
     */
    fun convertStringToInt(string: Any?): Int {
        if (string == "null") {
            return 0
        }
        return string!!.toString().toDouble().toInt()
    }
}