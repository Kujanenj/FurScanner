package sini.foxy.furscanner.Controller

import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.OnDataPass
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.model.*
import sini.foxy.furscanner.testLocation
import java.lang.Exception

/*!
The Controller class is used to control the logic of the App.
 */
class Controller : OnDataPass {


    private val parser = BarcodeParser()
    private val dateTime  = DateTime()
    val dataBaseManager = DataBaseManager("TEST SESSION",dateTime)
    private lateinit var adapter : CustomRecyclerAdapter

    override fun onDataPass(data: Pair<String, String>) {
           if(data.second!=""){
                when(data.first){
                   "bar" -> handleBarcodeResult(data.second)
                   "house" -> dataBaseManager.getLocation().house=data.second.toInt()
                   "cage" -> dataBaseManager.getLocation().cage=data.second.toInt()
                   "incA" -> dataBaseManager.getLocation().incAmount=data.second.toInt()
                   "incD" -> dataBaseManager.getLocation().incDir = data.second
                    "test"->populateDataBase()
       }
           }
    }

    override fun onDataPass(adapter: CustomRecyclerAdapter) {
        setAdapter(adapter)
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

    private fun handleBarcodeResult(scanResult : String ){


        var indexOfAddedAnimal = -1
        when(currentMode){
            Modes.NO_MODE -> throw Exception("No mode was selected!")
            Modes.BREED ->{
            try {
               indexOfAddedAnimal=dataBaseManager.modifyDataBase(AnimalFactory.createAnimal(currentMode,
                   parser.parseBarcode(scanResult),LocationFactory.createLocation(dataBaseManager.getLocation().getLocationData())))
                   if(indexOfAddedAnimal!=-1){
                        dataBaseManager.modifyLocation(dataBaseManager.getLocation().incAmount)
                        adapter.notifyItemInserted(indexOfAddedAnimal)
                }
            }
            catch (error : Exception){
                println(error)
            }
        }
            else -> throw Exception("Illegal mode")

    }
    }

    fun setAdapter(newAdapter : CustomRecyclerAdapter){
        println("Setting adapter")
        adapter=newAdapter
    }
    private fun handleDatBaseChange(indexOfAddedAnimal : Int){
    try {

    }
    catch (error : Exception){
        println(error)
    }

    }

  /*  fun modifyLocation(incrementation : Int){
        println("Current controller location is " + currentLocation.getLocationData())
        currentLocation.cage += incrementation
    }
    fun modifyLocation(houseP : Int, cageP : Int, incDirP : String, incAmountP : Int){
            currentLocation.house=houseP
            currentLocation.cage=cageP
            currentLocation.incDir=incDirP
            currentLocation.incAmount=incAmountP
    }
    fun modifyLocation(newLocation : Location){
        currentLocation=newLocation
    }

   */
    fun populateDataBase(){

        val randomGenerator = RandomGenerator()
        for (i in 0..1){
         handleBarcodeResult(randomGenerator.getRandomFurBarcode())
    }

        println("-----")
        for (animal in dataBaseManager.getContainer(Modes.BREED)){
            println(animal.getIDPair())
        }
    }


}