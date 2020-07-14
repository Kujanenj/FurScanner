package sini.foxy.furscanner


typealias IdPair = Pair<String,String> //Fox,Farm

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
