package sini.foxy.furscanner




class Parser(){
    private var activeMode = Modes.NO_MODE


    public fun setMode(newMode : Modes ) : Boolean{

        activeMode =  newMode

        return true
    }
    /*
    NOTE: Add some safetyGuards, and the test all!
     */
    public fun Parse(barcode : String) : IdPair {
       println("----Parse start---")


        var houseIDSubstring = barcode.substring(0,6)
        var foxIDSubstring = barcode.substring(7,15) //
        var indexToRemove = 0


        for (i in 0..houseIDSubstring.length){
            if(houseIDSubstring[i]!='0'){
                break
            }
            indexToRemove++
        }
        houseIDSubstring=houseIDSubstring.drop(indexToRemove)


        for (i in 0..foxIDSubstring.length){
            if(foxIDSubstring[]!='0'){
                break
            }
            indexToRemove++
        }
        foxIDSubstring=foxIDSubstring.drop(indexToRemove)
        foxIDSubstring=foxIDSubstring.dropLast(1)

        println("---Parse complete----")
        return IdPair(houseIDSubstring,foxIDSubstring)

    }

}