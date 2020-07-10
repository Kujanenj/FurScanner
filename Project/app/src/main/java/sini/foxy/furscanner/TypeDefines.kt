package sini.foxy.furscanner


typealias IdPair = Pair<String,String> //Fox,Farm

enum class Modes {
    BREED,
    NO_MODE
    }
enum class indentations (val amount : Int){
    HEADER(1)
}
val EmptyIDPair = IdPair("Empty","Empty")
