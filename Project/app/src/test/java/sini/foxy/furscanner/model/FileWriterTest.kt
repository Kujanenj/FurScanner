package sini.foxy.furscanner.model

import org.junit.Test
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.getPopulatedDataBaseManager
import sini.foxy.furscanner.testXMLFormer

class FileWriterTest {
    @Test
    fun testFileWrite(){
        val fileWriter = FileWriterConcrete()

            fileWriter.writeFile("../../FinalExamples/UTestResult/testi.xml",testXMLFormer.makeXML(getPopulatedDataBaseManager(4,
                Modes.BREED).getDataBase()))

    }
}