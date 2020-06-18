package sini.foxy.furscanner




class Parser(){
    private var activeMode = Modes.NO_MODE


    public fun setMode(newMode : Modes ) : Boolean{

        activeMode =  newMode

        return true
    }
    public fun Parse(barcode : String) : IdPair {
        TODO("not done")
    }

}