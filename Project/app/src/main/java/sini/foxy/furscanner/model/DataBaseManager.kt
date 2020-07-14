package sini.foxy.furscanner.model


import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AnimalInterface
import sini.foxy.furscanner.animals.BreedingAnimal
import java.lang.Exception

class DataBaseManager(sessionNumber: String, dateTime: DateTime) {

    private var database = DataBase()
    private var dateTime = dateTime //Todo: Should database have access to this?
    init { //TODO: try catch?
        database.generateXMLDataMap(sessionNumber,dateTime)
    }
    fun getDataBase( )=database

    //Todo: Add a way to delete animals?
    fun modifyDataBase(animal : AnimalInterface, mode : Modes): Boolean{

        when(mode){
            Modes.BREED -> try {
                database.addBreedAnimal(animal as BreedingAnimal)} //TODO: casting might not be safe for all types
            catch (error : Exception){  //TODO: Make your own execption class goddamnit
                println(error)
                return false
            }

        }

    return true
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
