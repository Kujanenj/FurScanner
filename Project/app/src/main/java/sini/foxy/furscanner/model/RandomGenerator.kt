package sini.foxy.furscanner.model

import sini.foxy.furscanner.IdPair

class RandomGenerator {

    fun getIdPairList(amount : Int):List<IdPair>{
        var returnList : MutableList<IdPair> = mutableListOf()

        for (i in 0..amount){
            returnList.add(i,getRandomIdPair())
        }
        return returnList
    }
    fun getRandomNumber(lower : Int, upper: Int) : Int{
        return (lower..upper).random()
    }
    fun getRandomIdPair():IdPair{
        return IdPair(getRandomNumber(100000,999999).toString(), getRandomNumber(1000,9999).toString())
    }

    }
