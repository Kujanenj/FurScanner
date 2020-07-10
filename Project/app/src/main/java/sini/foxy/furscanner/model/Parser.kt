package sini.foxy.furscanner.model

import sini.foxy.furscanner.IdPair
import java.lang.Exception


class Parser(){
   /* private var activeMode = Modes.NO_MODE


    public fun setMode(newMode : Modes ) : Boolean{

        activeMode =  newMode

        return true
    }

    */

    /*
    NOTE: Add some safetyGuards, and the test all!
     */
     fun parse(barcode : String) : IdPair {
       println("----Parse start---")

        if(barcode.length!=16){
            throw Exception("Wrong length barcode in parser: " + barcode.length +" chars")
        }


        var farmIDSubstring = barcode.substring(0,7)
        var foxIDSubstring = barcode.substring(7,16)
        var indexToRemove = 0


        for (i in 0..farmIDSubstring.length){
            if(farmIDSubstring[i]!='0'){
                break
            }
            indexToRemove++
        }

        farmIDSubstring=farmIDSubstring.drop(indexToRemove)

        indexToRemove=0
        for (i in 0..foxIDSubstring.length){
            if(foxIDSubstring[i]!='0'){
                break
            }
            indexToRemove++
        }

        foxIDSubstring=foxIDSubstring.drop(indexToRemove)

        foxIDSubstring=foxIDSubstring.dropLast(1)


        println("---Parse complete----")
        return IdPair(foxIDSubstring, farmIDSubstring)

    }

}