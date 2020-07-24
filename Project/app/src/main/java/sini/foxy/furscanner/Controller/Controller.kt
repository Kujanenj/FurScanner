package sini.foxy.furscanner.Controller

import android.content.Context
import com.journeyapps.barcodescanner.BarcodeResult
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.OnDataPass
import sini.foxy.furscanner.XML.XMLStringFormer
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.animals.AnimalInterface
import sini.foxy.furscanner.model.*
import sini.foxy.furscanner.testLocation
import java.lang.Exception


class Controller() : OnDataPass {


    private val parser = Parser()
    private val dateTime  = DateTime()
    private val dataBaseManager = DataBaseManager("TEST SESSION",dateTime)
    private var  currentLocation = testLocation

    override fun onDataPass(data: Pair<String, String>) {
        println("CONTROLLER")
       when(data.first){
           "house" -> currentLocation.house=data.second.toInt()
           "cage" -> currentLocation.cage=data.second.toInt()
           "incA" -> currentLocation.incAmount=data.second.toInt()
           "incD" -> currentLocation.incDir = data.second
           "bar" -> handleBarcodeResult(data.second)
       }
    }

    private var currentMode : Modes =
        Modes.BREED

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

    fun handleBarcodeResult(scanResult : String ){

        when(currentMode){
            Modes.NO_MODE -> throw Exception("No mode was selected!")
            Modes.BREED ->{
            try {
               if(!dataBaseManager.modifyDataBase(AnimalFactory.createAnimal(currentMode,
                   parser.parse(scanResult),currentLocation),currentMode)){
                   //TODO: if something goes wrong when adding to database
               }
                modifyLocation(currentLocation.incAmount)
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

    fun modifyLocation(incrementation : Int){
        currentLocation.cage += incrementation
    }
    fun modifyLocation(houseP : Int, cageP : Int, incDirP : String, incAmountP : Int){
        if(currentLocation!=null){
            currentLocation.house=houseP
            currentLocation.cage=cageP
            currentLocation.incDir=incDirP
            currentLocation.incAmount=incAmountP
        }
        else{
            currentLocation= Location(houseP,cageP,incDirP,incAmountP)
        }
    }
    fun modifyLocation(newLocation : Location){
        currentLocation=newLocation
    }
}