package sini.foxy.furscanner.XML

import org.junit.Test
import sini.foxy.furscanner.Modes

import sini.foxy.furscanner.getPopulatedDataBaseManager
import sini.foxy.furscanner.testXMLFormer


class XMLStringFormerTest {
    @Test
    fun testFormStringBreed5(){
        println(testXMLFormer.makeXML(getPopulatedDataBaseManager(5,Modes.BREED).getDataBase()))
    }
}