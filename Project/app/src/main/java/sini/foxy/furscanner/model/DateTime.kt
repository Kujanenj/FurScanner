package sini.foxy.furscanner.model

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
/*!
TODO: Make this class a singleton?
 */
class DateTime : Date() { //TODO: Could be global, as to avoid passing as parameter?
    fun getDateISO()  =  DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ssX:00")
        .withZone(ZoneOffset.systemDefault())
        .format(Instant.now()).toString()




}