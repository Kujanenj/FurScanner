package sini.foxy.furscanner

import java.lang.Exception

class DataBase {
  private  val breedContainer = mutableListOf<IdPair>()//List of ID's.

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

}