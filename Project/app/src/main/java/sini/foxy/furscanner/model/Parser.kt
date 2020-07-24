package sini.foxy.furscanner.model

import sini.foxy.furscanner.IdPair
import java.lang.Exception


class Parser(){
    /* TODO: Add some safetyGuards, and the test all!
    Also, make parser better.
     */
     fun parse(barcode : String) : IdPair {
       println("----Parse start---")

        if(barcode.length!=16){
            throw Exception("Wrong length barcode in parser: " + barcode.length +" chars")
        }


        var farmIDSubstring = barcode.substring(0,7)
        var sampoIDSubstring = barcode.substring(7,16)
        var indexToRemove = 0

        //remove extra 0's from farmID
        for (i in 0..farmIDSubstring.length){
            if(farmIDSubstring[i]!='0'){
                break
            }
            indexToRemove++
        }

        farmIDSubstring=farmIDSubstring.drop(indexToRemove)
        //remove extra 0's from sampoID
        indexToRemove=0
        for (i in 0..sampoIDSubstring.length){
            if(sampoIDSubstring[i]!='0'){
                break
            }
            indexToRemove++
        }

        sampoIDSubstring=sampoIDSubstring.drop(indexToRemove)

        sampoIDSubstring=sampoIDSubstring.dropLast(1)


        println("---Parse complete----")
        return IdPair(farmIDSubstring, sampoIDSubstring)

    }

}