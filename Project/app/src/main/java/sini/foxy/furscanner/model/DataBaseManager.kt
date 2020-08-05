package sini.foxy.furscanner.model


import sini.foxy.furscanner.Exception.IllegalAnimalException
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AbstractAnimal
import sini.foxy.furscanner.animals.BreedingAbstractAnimal
import sini.foxy.furscanner.model.Listeners.AbstractObservable
import java.lang.Exception

//TODO: This class is fucking shit. Make a better one before spaghetti is born!
/**
 * DataBaseManager is used when interacting with the actual database.
 */
class DataBaseManager(sessionNumber: String, dateTime: DateTime)  : AbstractObservable(){

    private var database = DataBase()
    private var dateTime = dateTime //Todo: Should database have access to this?
    init { //TODO: try catch?
        database.generateXMLDataMap(sessionNumber,dateTime)
    }
    //TODO: Holy fuck remove this
  //  fun getDataBase( )=database
    fun getLocation() = database.getCurrentLocation()
    fun getContainer(type : Modes) : MutableList<AbstractAnimal>{
        return database.getContainer(type)
    }
    fun getXMLData(): MutableMap<String,String>{
        return database.getXMLDataMap()
    }
    //Todo: Add a way to delete animals?
    /*!
    Adds the given animal to correct database based on the mode of the animal. Returns the index of the added animal
     */
    fun modifyDataBase(abstractAnimal : AbstractAnimal): Int{


        var indexOfAddedAnimal = -1
        when(abstractAnimal.mode){
            Modes.BREED -> try {
                indexOfAddedAnimal=database.addBreedAnimal(abstractAnimal as BreedingAbstractAnimal)//TODO: casting might not be safe for all types
            }
            catch (illegalAnimalException : IllegalAnimalException){
              illegalAnimalException.print()
                indexOfAddedAnimal = -1 //invalid index is -1
            }
        }
        println(indexOfAddedAnimal)

        return indexOfAddedAnimal
        }

    fun modifyLocation(incrementation : Int){
     database.modifyLocation(incrementation)
        updateObservers()
    }
    fun modifyLocation(houseP : Int, cageP : Int, incDirP : String, incAmountP : Int){
        database.modifyLocation(houseP,cageP,incDirP,incAmountP)
        updateObservers()
    }
    fun modifyLocation(newLocation : sini.foxy.furscanner.Location){
        database.modifyLocation(newLocation)
        updateObservers()
    }
    fun modifyLocation(key : String , value : String){
        database.modifyLocation(key,value)
       // updateObservers()
    }
    fun modifyDataBase(key: String, value : String){ //Modifies XML database
        try {
        database.modifyXMLDataMap(key,value)
        }
        catch (error : Exception){
            println(error) //TODO: Make your own execption class goddamnit
        }
    }


}
