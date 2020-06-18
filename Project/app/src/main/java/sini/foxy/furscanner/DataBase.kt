package sini.foxy.furscanner

class DataBase {
  private lateinit var breedContainer : MutableList<Pair<String,String>> //List of ID's. e.g, 337820,5520 (FOX ID, FARM ID)

    public fun getContainer(containerType : String? ) : List<Pair<String, String>>
    {
        if(containerType=="breed"){
            return breedContainer
        }


        else{
            return emptyList()
        }
    }

    public fun addAnimal(AnimalID : String?, FarmID : String?) : Boolean{
        if(breedContainer.contains(Pair(AnimalID,FarmID))){
            return false
        }
        breedContainer.add(Pair(AnimalID,FarmID) as Pair<String, String>)
        return true
    }

}