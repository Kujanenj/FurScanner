package sini.foxy.furscanner.animals

import sini.foxy.furscanner.Genders
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes


/*!
Abstract class for all animal types
 */
open class AbstractAnimal(idPair: IdPair, location: Location, mode: Modes, gender : Genders = Genders.UNKNOWN) {
    var birthFarm = idPair.first
    var sampoId= idPair.second
    var animalLocation = location
    val gender = gender.data
    val mode: Modes = mode
    val animalTypeName: String = mode.toString()

    fun getIDPair() = IdPair(birthFarm,sampoId)
    fun getAnimalType() = animalTypeName
    fun getLocation() = animalLocation

}