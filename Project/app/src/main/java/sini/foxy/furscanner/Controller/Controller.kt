package sini.foxy.furscanner.Controller

import android.app.Application
import android.content.Context
import sini.foxy.furscanner.Exception.FurScannerException
import sini.foxy.furscanner.Exception.IllegalModeException
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.OnDataPass
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter
import sini.foxy.furscanner.XML.XMLStringFormer
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.model.*
import sini.foxy.furscanner.testLocation
import java.lang.Exception

/*!
The Controller class is used to control the logic of the App.
 */
class Controller : OnDataPass {

    private lateinit var context : Context
    private val parser = BarcodeParser()
    private val dateTime  = DateTime()
    val dataBaseManager = DataBaseManager("TEST SESSION",dateTime)
    private val xmlStringFormer = XMLStringFormer()
    private val fileWriter : FileWriterInterface = FileWriterConcrete()
    private lateinit var adapter : CustomRecyclerAdapter
    private var currentMode : Modes = Modes.BREED
    override fun onDataPass(data: Pair<String, String>) {
           if(data.second!=""){
                when(data.first){

                   "bar" -> handleBarcodeResult(data.second)
                   "house" -> dataBaseManager.modifyLocation("house",data.second)
                   "cage" -> dataBaseManager.modifyLocation("cage",data.second)
                   "incA" -> dataBaseManager.modifyLocation("cage",data.second)
                   "incD" -> dataBaseManager.getLocation().incDir = data.second
                    "export"->
                        fileWriter.writeFile(
                            context.filesDir.toString() +
                                    "/TEST SESSION.xml", xmlStringFormer.makeXML(dataBaseManager)
                        )

                    "test"->populateDataBase()
       }
           }
    }

    override fun onDataPass(adapter: CustomRecyclerAdapter) {
        setAdapter(adapter)
    }

    fun setContext(newContext : Context){
        context=newContext
    }
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
            catch (error : FurScannerException){
                error.print()
            }
        }
            else -> throw Exception("Illegal mode")

    }
    }

    fun setAdapter(newAdapter : CustomRecyclerAdapter){
        println("Setting adapter")
        adapter=newAdapter
    }

    fun populateDataBase(){

        val randomGenerator = RandomGenerator()
        for (i in 0..1){
         handleBarcodeResult(randomGenerator.getRandomFurBarcode())
    }



    }


}