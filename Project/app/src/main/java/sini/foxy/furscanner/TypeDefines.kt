package sini.foxy.furscanner


typealias IdPair = Pair<String,String>

enum class Modes {
    BREED,
    NO_MODE
    }

/*!
TODO: enum might not be the way to go here. Test and/or look into other options
 */
enum class Location(var data : String){
    HouseNumber("empty"),
    CageNumber("empty")
}
enum class Incrementation(var data : String){
    Direction("ASC"),
    Amount("2")
}
enum class generalData(var data : String){
    SessionNumber ("empty"),
    Date ("empty")
}
val EmptyIDPair = IdPair("Empty","Empty")

var generalDataMap = mutableMapOf<String,String>("SESSION_NUMBER" to "EMPTY_SESSION",
    "DATE" to "EMPTY_DATE"
 )
