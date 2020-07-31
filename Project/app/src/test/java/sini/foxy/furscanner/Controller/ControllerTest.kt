package sini.foxy.furscanner.Controller


import org.junit.Test
import sini.foxy.furscanner.getRandomFurBarcode
import sini.foxy.furscanner.testBarcodeResult1
import sini.foxy.furscanner.testController
import sini.foxy.furscanner.testLocation

class ControllerTest {

    @Test
    fun testHandleBarcode(){
       testController.onDataPass(Pair("bar", testBarcodeResult1))
    }
    @Test
    fun testHandleBarcodeRandom10(){
        for (i in 0..9){
            testController.onDataPass(Pair("bar", getRandomFurBarcode()))
        }
    }
}