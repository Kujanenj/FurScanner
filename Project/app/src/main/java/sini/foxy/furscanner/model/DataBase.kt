package sini.foxy.furscanner.model


import android.location.Location
import sini.foxy.furscanner.Exception.IllegalAnimalException
import sini.foxy.furscanner.Exception.IllegalModeException
import sini.foxy.furscanner.Genders
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AbstractAnimal
import sini.foxy.furscanner.animals.BreedingAbstractAnimal
import sini.foxy.furscanner.testLocation
import java.lang.Exception

class DataBase {

    private var dateTime = DateTime()
    private var xmlDataMap = mutableMapOf<String,String>( //TODO: Make a better container for generalData
        "SESSION_NUMBER" to "EMPTY_SESSION",
        "DATE" to "EMPTY_DATE",
        "HAS_CHANGES" to "true",
        "GRADING" to "UNKNOWN",
        "GENDER_RESET" to "true",
        "CURRENT_GENDER" to Genders.UNKNOWN.data
    )

    private val breedContainerList = mutableListOf<BreedingAbstractAnimal>()

    private var currentLocation = testLocation

    fun getDateTime() = dateTime.getDateISO()
    fun modifyLocation(incrementation : Int){
        currentLocation.cage += incrementation

    }
    fun modifyLocation(houseP : Int, cageP : Int, incDirP : String, incAmountP : Int){
        currentLocation.house=houseP
        currentLocation.cage=cageP
        currentLocation.incDir=incDirP
        currentLocation.incAmount=incAmountP
    }
    fun modifyLocation(newLocation : sini.foxy.furscanner.Location){
        currentLocation=newLocation
    }
    fun modifyLocation(key : String, value : String){
        when(key){
            "house" -> currentLocation.house=value.toInt()
            "cage" -> currentLocation.cage=value.toInt()
            "incA" -> currentLocation.incAmount=value.toInt()
        }

    }
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
                throw IllegalAnimalException("Animal: " + animalToAdd.sampoId + " already exists in breedContainer","DatBase.addBreedAnimal")

            }
        }
        breedContainerList.add(animalToAdd)
        println("Added breeding animal, " + animalToAdd.getIDPair() + ", \n with location of : " + animalToAdd.getLocation().getLocationData())
        return breedContainerList.size
    }
    fun getContainer(type : Modes) : MutableList<AbstractAnimal>{
        when(type){

            Modes.BREED -> return breedContainerList as MutableList<AbstractAnimal>
        }
        throw IllegalModeException(type,"Database.getContainer")
    }
    fun getXMLDataMap() = xmlDataMap
   // fun getBreedContainer() = breedContainerList
    fun getCurrentLocation() = currentLocation
}



