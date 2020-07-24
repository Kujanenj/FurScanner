package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.*
import java.lang.Exception

class ParserTests {
    @Test
    fun testSimpleParse(){
        Assert.assertEquals(IdPair("5302","604408"),testParser.parse(  testBarcodeResult1))
        Assert.assertEquals(IdPair("52222","2020202"),testParser.parse(testBarcodeResult2))

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

    @Test
    fun testRandomParse10(){
        for (i in 0..9){
            testParser.parse(getRandomFurBarcode())
        }
    }
}