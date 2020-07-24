package sini.foxy.furscanner

import sini.foxy.furscanner.Controller.Controller
import sini.foxy.furscanner.XML.XMLStringFormer
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.model.DataBaseManager
import sini.foxy.furscanner.model.DateTime
import sini.foxy.furscanner.model.BarcodeParser

val testPair : IdPair = IdPair("5302","604418")
val testXMLFormer = XMLStringFormer()
val testLocation : Location = Location(0,0,"Ascending",2)
val testAnimal = AnimalFactory.createAnimal(Modes.BREED, testPair, testLocation)
val testController = Controller()
val testDateTime = DateTime()
val testParser= BarcodeParser()
val testSessionNumber = "TEST SESSION!"
val testBarcodeResult1 = "0005302006044080"
val testBarcodeResult2 = "0052222020202020"

fun getPopulatedDataBaseManager(amount : Int, mode : Modes): DataBaseManager{
    val populatedDatabaseManager = DataBaseManager(testSessionNumber, testDateTime)
    var previousLocation : Location = testLocation

    for(i in 1..amount){
            previousLocation= getNextLocation(previousLocation,256)
            while(populatedDatabaseManager.modifyDataBase(AnimalFactory.createAnimal(mode, getRandomIdPair(),previousLocation))==-1){
                println("Adding a new animal in place of previous")
            }



    }
    return populatedDatabaseManager
}

fun getRandomNumber(lower : Int, upper: Int) : Int{
    return (lower..upper).random()
}
fun getRandomIdPair():IdPair{
    return IdPair(getRandomNumber(1000,9999).toString(), getRandomNumber(100000,999999).toString())
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
fun getRandomFurBarcode()=  "000" + getRandomNumber(1000,9999)+
        "00"+ getRandomNumber(100000,999999)+ "0"

