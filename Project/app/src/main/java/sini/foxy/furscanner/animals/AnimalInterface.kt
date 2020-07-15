package sini.foxy.furscanner.animals

import sini.foxy.furscanner.Genders
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes

open class AnimalInterface(idPair: IdPair,location: Location, mode: Modes, gender : Genders = Genders.UNKNOWN) {
    var sampoId = idPair.first
    var birthFarm = idPair.second
    var animalLocation = location
    val gender = gender.data
    val mode: Modes = mode
    val animalTypeName: String = mode.toString()

    fun getIDPair() = IdPair(sampoId, birthFarm)
    fun getAnimalType() = animalTypeName
    fun getLocation() = animalLocation

}