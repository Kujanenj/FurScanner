package sini.foxy.furscanner


typealias IdPair = Pair<String,String> //Farm,Fox
enum class Genders (val data : String){
    MALE("130"),
    FEMALE("131"),
    UNKNOWN("129")
}

enum class Modes {
    BREED,
    NO_MODE
    }
class Location(houseP : Int, cageP : Int, incDirP : String, incAmountP : Int){
    var house = houseP
    var cage = cageP
    var incDir = incDirP
    var incAmount = incAmountP
    fun getLocationData(): List<String> = listOf(house.toString(),cage.toString(),incDir,incAmount.toString())

}
val EmptyIDPair = IdPair("Empty","Empty")
val testLocation : Location = Location(0,0,"Ascending",2)