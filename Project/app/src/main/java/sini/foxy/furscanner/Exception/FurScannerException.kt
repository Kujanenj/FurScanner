package sini.foxy.furscanner.Exception

import java.lang.Exception

open class FurScannerException(val what : String, val where : String) : Exception() {
    fun what() = what
    fun where() = where
}