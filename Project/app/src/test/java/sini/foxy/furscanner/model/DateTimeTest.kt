package sini.foxy.furscanner.model

import org.junit.Test
import sini.foxy.furscanner.testDateTime

class DateTimeTest { //TODO: Make an actual test
    @Test
    fun testCurrentTime(){
        println(testDateTime.getDateISO())
    }
}