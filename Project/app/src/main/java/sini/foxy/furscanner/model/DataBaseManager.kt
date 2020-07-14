package sini.foxy.furscanner.model


import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AnimalInterface
import sini.foxy.furscanner.animals.BreedingAnimal
import java.lang.Exception

class DataBaseManager {

    private var database = DataBase()

    fun getDataBase( ) : DataBase
    {
      return database
    }

    //Todo: Add a way to delete animals?
    fun modifyDataBase(animal : AnimalInterface, mode : Modes): Boolean{

        when(mode){
            Modes.BREED -> try {
                database.addBreedAnimal(animal as BreedingAnimal)} //TODO: casting might not be safe for all types
            catch (error : Exception){
                println(error)
                return false
            }

        }

    return true
 }


}
