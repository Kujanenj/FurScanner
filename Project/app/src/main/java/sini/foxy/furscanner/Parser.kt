package sini.foxy.furscanner



enum class Modes( ) {
    BREED,
    NOMODE
}
class Parser(){
    private var activeMode = Modes.NOMODE


    public fun setMode(newMode : Modes ) : Boolean{

        activeMode =  newMode

        return true
    }
    public fun Parse(barcode : String) : IdPair {
        TODO("not done")
    }

}