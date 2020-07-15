package sini.foxy.furscanner

import sini.foxy.furscanner.XML.XMLStringFormer
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.model.DataBase
import sini.foxy.furscanner.model.DataBaseManager
import sini.foxy.furscanner.model.DateTime
import java.lang.Exception

val testPair : IdPair = IdPair("604418","5302")
val testXMLFormer = XMLStringFormer()
val testLocation : Location = Location(0,0,"Ascending",2)
val testAnimal = AnimalFactory.createAnimal(Modes.BREED, testPair, testLocation)
val testDateTime = DateTime()
val testSessionNumber = "TEST SESSION!"


fun getPopulatedDataBaseManager(amount : Int, mode : Modes): DataBaseManager{
    val populatedDatabaseManager = DataBaseManager(testSessionNumber, testDateTime)
    var previousLocation : Location = testLocation

    for(i in 1..amount){
            previousLocation= getNextLocation(previousLocation,256)
            while(!populatedDatabaseManager.modifyDataBase(AnimalFactory.createAnimal(mode, getRandomIdPair(),previousLocation),Modes.BREED)){
                println("Adding a new animal in place of previous")
            }



    }
    return populatedDatabaseManager
}

fun getRandomNumber(lower : Int, upper: Int) : Int{
    return (lower..upper).random()
}
fun getRandomIdPair():IdPair{
    return IdPair(getRandomNumber(100000,999999).toString(), getRandomNumber(1000,9999).toString())
}
fun getNextLocation(previous : Location, numberOfCages : Int) : Location {
    when(previous.incDir){
        "Ascending" -> if(!(previous.cage + previous.incAmount > numberOfCages)){ // House still has room
            return Location(previous.house,previous.cage+previous.incAmount,"Ascending",previous.incAmount)
        }
        else{
            return Location(previous.house+1,0,previous.incDir,previous.incAmount)
        }
    }
    return testLocation //Todo: Make test case for descening direction
}