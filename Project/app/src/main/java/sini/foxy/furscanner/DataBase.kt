package sini.foxy.furscanner

import java.lang.Exception

class DataBase {


    private var xmlDataMap = mutableMapOf<String,String>(
        "SESSION_NUMBER" to "EMPTY_SESSION",
        "DATE" to "EMPTY_DATE",
        "HOUSE_NUMBER" to "EMPTY",
        "CAGE_NUMBER" to "EMPTY",
        "DIRECTION" to "ASC",
        "INC_AMOUNT" to "2"
    )

    private  val breedContainer = mutableListOf<IdPair>(IdPair("604418","5302"),IdPair("604408","5302"))//List of ID's.

     /* public fun getContainer(containerType : String? ) : List<IdPair>
    {
        return if(containerType=="breed"){
            breedContainer
        } else{
            emptyList()
        }
    }
*/
        fun addAnimal(animalPair : IdPair) : Boolean{
            if(breedContainer.contains(animalPair)){
                throw Exception("Animal already contained in database!")
            }
            breedContainer.add(animalPair)
            println("Added pair $animalPair")
            return true
    }
    fun getXMLDataMap() = xmlDataMap

}
