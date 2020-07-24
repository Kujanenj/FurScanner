package sini.foxy.furscanner.model


import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AbstractAnimal
import sini.foxy.furscanner.animals.BreedingAbstractAnimal
import java.lang.Exception


/**
 * DataBaseManager is used when interacting with the actual database.
 */
class DataBaseManager(sessionNumber: String, dateTime: DateTime) {

    private var database = DataBase()
    private var dateTime = dateTime //Todo: Should database have access to this?
    init { //TODO: try catch?
        database.generateXMLDataMap(sessionNumber,dateTime)
    }
    fun getDataBase( )=database

    //Todo: Add a way to delete animals?
    /*!
    Adds the given animal to correct database based on the mode of the animal. Returns the index of the added animal
     */
    fun modifyDataBase(abstractAnimal : AbstractAnimal): Int{

        var indexOfAddedAnimal = -1
        when(abstractAnimal.mode){
            Modes.BREED -> indexOfAddedAnimal=database.addBreedAnimal(abstractAnimal as BreedingAbstractAnimal)} //TODO: casting might not be safe for all types
        println(indexOfAddedAnimal)
             //TODO: Make your own execption class goddamnit
        return indexOfAddedAnimal
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
