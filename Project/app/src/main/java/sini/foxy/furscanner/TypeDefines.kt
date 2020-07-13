package sini.foxy.furscanner


typealias IdPair = Pair<String,String> //Fox,Farm

enum class Modes {
    BREED,
    NO_MODE
    }
class Location(houseP : String, cageP : String, incDirP : String, incAmountP : String){
    var house = houseP
    var cage = cageP
    var incDir = incDirP
    var incAmount = incAmountP

}
val EmptyIDPair = IdPair("Empty","Empty")
