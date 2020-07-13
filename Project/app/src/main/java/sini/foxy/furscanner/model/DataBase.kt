package sini.foxy.furscanner.model

import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.animals.BreedingAnimal

class DataBase {

    private var xmlDataMap = mutableMapOf<String,String>(
        "SESSION_NUMBER" to "EMPTY_SESSION",
        "DATE" to "EMPTY_DATE",
        "HOUSE_NUMBER" to "EMPTY",
        "CAGE_NUMBER" to "EMPTY",
        "DIRECTION" to "ASC",
        "INC_AMOUNT" to "2"
    )
    private  val breedContainer = mutableMapOf<String, BreedingAnimal>()//List of breeding animals

    fun addBreedAnimal(animalToAdd: BreedingAnimal) : Boolean { //TODO: Increase asymtotic speed? from n to log n
        if(breedContainer.contains(animalToAdd.sampoId)){
            throw Exception("Animal already contained in database!")
        }

        breedContainer[animalToAdd.sampoId]=animalToAdd
        println("Added breeding animal, " + animalToAdd.sampoId)
        return true
    }
    fun getXMLDataMap() = xmlDataMap
    fun getBreedContainer() = breedContainer
}



