package sini.foxy.furscanner

import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.model.DataBase
import sini.foxy.furscanner.model.DataBaseManager
import java.lang.Exception

val testPair : IdPair = IdPair("604418","5302")
val testDataBaseManager = DataBaseManager()
val testLocation : Location = Location(0,0,"ASC",2)
val testAnimal = AnimalFactory.createAnimal(Modes.BREED, testPair, testLocation)


fun makePopulatedDataBase(amount : Int, mode : Modes): DataBase{
    val populatedDatabaseManager = DataBaseManager()
    var previousLocation : Location = testLocation
    var runningCount = 0
    //populatedDatabaseManager.modifyDataBase(testAnimal,Modes.BREED)
    for(i in 1..amount){

            previousLocation= getNextLocation(previousLocation,256)
            println("Running count of animal is "+ runningCount)
            while(!populatedDatabaseManager.modifyDataBase(AnimalFactory.createAnimal(mode, getRandomIdPair(),previousLocation),Modes.BREED)){
                println("Adding a new animal in place of previous")
            }
            runningCount+=1


    }
    return populatedDatabaseManager.getDataBase()
}

fun getRandomNumber(lower : Int, upper: Int) : Int{
    return (lower..upper).random()
}
fun getRandomIdPair():IdPair{
    return IdPair(getRandomNumber(100000,999999).toString(), getRandomNumber(1000,9999).toString())
}
fun getNextLocation(previous : Location, numberOfCages : Int) : Location {
    when(previous.incDir){
        "ASC" -> if(!(previous.cage + previous.incAmount > numberOfCages)){ // House still has room
            return Location(previous.house,previous.cage+previous.incAmount,"ASC",previous.incAmount)
        }
        else{
            return Location(previous.house+1,0,previous.incDir,previous.incAmount)
        }
    }
    return testLocation //Todo: Make test case for descening direction
}