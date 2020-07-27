package sini.foxy.furscanner.model

import sini.foxy.furscanner.Location

class LocationFactory {

    companion object LocationCreation {
        fun createLocation(house : Int, cage : Int, incAmount : Int, incDir : String) : Location {
            return Location(house,cage, incDir, incAmount)
        }
        fun createLocation(dataList : List<String>) : Location {
            return Location(dataList[0].toInt(),dataList[1].toInt(),dataList[2],dataList[3].toInt())
        }
    }
}