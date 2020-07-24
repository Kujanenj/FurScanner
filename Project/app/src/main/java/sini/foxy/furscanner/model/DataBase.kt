package sini.foxy.furscanner.model


import sini.foxy.furscanner.animals.BreedingAbstractAnimal

class DataBase {

    private var xmlDataMap = mutableMapOf<String,String>( //TODO: Make a better container for generalData
        "SESSION_NUMBER" to "EMPTY_SESSION",
        "DATE" to "EMPTY_DATE",
        "HAS_CHANGES" to "UNKNOWN",
        "GRADING" to "UNKNOWN",
        "GENDER_RESET" to "UNKNOWN",
        "CURRENT_GENDER" to "UNKNOWN",
        "HOUSE_NUMBER" to "EMPTY",
        "CAGE_NUMBER" to "EMPTY",
        "DIRECTION" to "ASC",
        "INC_AMOUNT" to "2"
    )

    private val breedContainerList = mutableListOf<BreedingAbstractAnimal>()
    fun modifyXMLDataMap(key: String, value : String){ //Todo: This function is useless?
        xmlDataMap[key]=value
    }
    fun generateXMLDataMap(sessionNumber: String,dateTime: DateTime){
        xmlDataMap["SESSION_NUMBER"]=sessionNumber
        xmlDataMap["DATE"]=dateTime.getDateISO()
    }
    fun addBreedAnimal(animalToAdd: BreedingAbstractAnimal) : Int  { //TODO: Increase asymtotic speed? from n to log n

        for (animal in breedContainerList) {
            if (animalToAdd.sampoId==animal.sampoId) {
                println("Animal: " + animalToAdd.sampoId + " already contained in database!")
                return -1
            }
        }
        breedContainerList.add(animalToAdd)
        println("Added breeding animal, " + animalToAdd.getIDPair() + ", \n with location of : " + animalToAdd.getLocation().getLocationData())
        return breedContainerList.size
    }
    fun getXMLDataMap() = xmlDataMap
    fun getBreedContainer() = breedContainerList
}



