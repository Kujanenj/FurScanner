package sini.foxy.furscanner.model

import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Modes

class DataBaseManager {


    private var database = DataBase()


    //TODO: Remake this func to be more expandable
    fun getDataBase( ) : DataBase
    {
      return database
    }

    fun modifyDataBase(animalPair : IdPair, mode : Modes) : Boolean{

        when(mode){
            Modes.BREED -> database.addBreedAnimal(animalPair)
        }

        return true
 }


}
