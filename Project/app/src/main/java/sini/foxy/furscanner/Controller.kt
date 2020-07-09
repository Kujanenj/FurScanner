package sini.foxy.furscanner

import android.content.Context
import com.journeyapps.barcodescanner.BarcodeResult
import java.lang.Exception


class Controller(private val testContext: Context) {


    private var currentMode : Modes = Modes.NO_MODE
    private val dataBaseManager = DataBaseManager()
    private val parser =  Parser()
    private var testFORMER = XMLStringFormer(testContext)


     fun setMode(newMode : Modes ) : Boolean{

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
                dataBaseManager.modifyDataBase(parser.parse(scanResult.toString()),currentMode)
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
       // testWriter.writeFile("/data/data/sini.foxy.furscanner/cache/testfile.txt",testFORMER.formXMLFile(dataBase.getXMLDataMap(),
         //   dataBase.getContainer("")))
        println(testFORMER.formXMLFile(dataBaseManager.getDataBase()))
    }
    catch (error : Exception){
        println(error)
    }

    }
}