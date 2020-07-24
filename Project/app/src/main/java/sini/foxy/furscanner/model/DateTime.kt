package sini.foxy.furscanner.model

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
/*!
TODO: Make this class a singleton?
 */
class DateTime : Date() { //TODO: Could be global, as to avoid passing as parameter?
    fun getDateISO() : String = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        .withZone(ZoneOffset.systemDefault())
        .format(Instant.now())

}