package sini.foxy.furscanner

import android.content.Context
import com.journeyapps.barcodescanner.BarcodeResult
import java.lang.Exception


class Controller(private val testContext: Context) {


    private var currentMode : Modes = Modes.NO_MODE
    private val dataBase = DataBase()
    private val parser =  Parser()
    private val testWriter : FileWriterInterface = FileWriterConcrete()
    private var testFORMER = XMLStringFormer(testContext)


    public fun setMode(newMode : Modes ) : Boolean{

        try {
        currentMode =  newMode
        }
        catch (error : Exception){
            println(error)
            return false
        }
        return true
    }

    fun handleBarcodeResult(scanResult : BarcodeResult){

        when(currentMode){
            Modes.NO_MODE -> throw Exception("No mode was selected!")
            Modes.BREED ->{
            try {
                dataBase.addAnimal(parser.parse(scanResult.toString()))
            }
            catch (error : Exception){
                println(error)
            }
        }
            else -> throw Exception("Illegal mode")

    }

    }
    fun handleCompleteButton(){
    try {
        testWriter.writeFile("/data/data/sini.foxy.furscanner/cache/testfile.txt",testFORMER.formXMLFile(dataBase.getXMLDataMap()))
    }
    catch (error : Exception){
        println(error)
    }

    }
}