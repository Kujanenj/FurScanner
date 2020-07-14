package sini.foxy.furscanner.Controller

import android.content.Context
import com.journeyapps.barcodescanner.BarcodeResult
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.XML.XMLStringFormer
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.animals.AnimalInterface
import sini.foxy.furscanner.model.DataBaseManager
import sini.foxy.furscanner.model.FileWriterConcrete
import sini.foxy.furscanner.model.FileWriterInterface
import sini.foxy.furscanner.model.Parser
import java.lang.Exception


class Controller(private val testContext: Context) {


    private var currentMode : Modes =
        Modes.NO_MODE



     fun setMode(newMode : Modes) : Boolean{

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
               //TODO: handle breedEvent
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
       //testWriter.writeFile("/data/data/sini.foxy.furscanner/cache/testfile.txt",testFORMER.createTest())

    }
    catch (error : Exception){
        println(error)
    }

    }
}