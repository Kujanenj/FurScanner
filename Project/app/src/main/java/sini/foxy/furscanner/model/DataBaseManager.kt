package sini.foxy.furscanner.model


import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AnimalInterface
import sini.foxy.furscanner.animals.BreedingAnimal

class DataBaseManager {

    private var database = DataBase()

    fun getDataBase( ) : DataBase
    {
      return database
    }

    //Todo: Add a way to delete animals?
    fun modifyDataBase(animal : AnimalInterface, mode : Modes) : Boolean{

        when(mode){

            Modes.BREED -> database.addBreedAnimal(animal as BreedingAnimal) //TODO: casting might not be safe for all types
        }

        return true
 }


}
