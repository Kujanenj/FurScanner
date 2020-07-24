package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.*
import java.lang.Exception

class BarcodeParserTests {
    @Test
    fun testSimpleParse(){
        Assert.assertEquals(IdPair("5302","604408"),testParser.parseBarcode(  testBarcodeResult1))
        Assert.assertEquals(IdPair("52222","2020202"),testParser.parseBarcode(testBarcodeResult2))

    }
    @Test
    fun testTooShortCode(){
        try {
            testParser.parseBarcode("000")
        }
        catch (error : Exception){
            Assert.assertEquals("java.lang.Exception: Wrong length barcode in parser: 3 chars",error.toString())
        }
    }

    @Test
    fun testRandomParse10(){
        for (i in 0..9){
            testParser.parseBarcode(getRandomFurBarcode())
        }
    }
}