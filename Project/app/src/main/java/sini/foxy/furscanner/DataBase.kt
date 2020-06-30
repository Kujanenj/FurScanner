package sini.foxy.furscanner

class DataBase {
  private lateinit var breedContainer : MutableList<IdPair> //List of ID's.

    public fun getContainer(containerType : String? ) : List<IdPair>
    {
        return if(containerType=="breed"){
            breedContainer
        } else{
            emptyList()
        }
    }

    public fun addAnimal(AnimalID : String, FarmID : String) : Boolean{
        if(breedContainer.contains(Pair(AnimalID,FarmID))){
            return false
        }
        breedContainer.add(Pair(AnimalID,FarmID))
        return true
    }

}