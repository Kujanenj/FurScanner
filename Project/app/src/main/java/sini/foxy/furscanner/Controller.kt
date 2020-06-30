package sini.foxy.furscanner

import com.journeyapps.barcodescanner.BarcodeResult
import java.lang.Exception


class Controller {
    var currentMode : Modes = Modes.NO_MODE
    private val dataBase = DataBase()
    val parser =  Parser()

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
}