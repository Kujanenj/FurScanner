package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.IdPair
import java.lang.Error
import java.lang.Exception

class ParserTests {
    val testParser= Parser()
    @Test
    fun testSimpleParse(){
        Assert.assertEquals(IdPair("604408","5302"),testParser.parse(  "0005302006044080"))
        Assert.assertEquals(IdPair("2020202","52222"),testParser.parse("0052222020202020"))

    }
    @Test
    fun testTooShortCode(){
        try {
            testParser.parse("000")
        }
        catch (error : Exception){
            Assert.assertEquals("java.lang.Exception: Wrong length barcode in parser: 3 chars",error.toString())
        }
    }
}