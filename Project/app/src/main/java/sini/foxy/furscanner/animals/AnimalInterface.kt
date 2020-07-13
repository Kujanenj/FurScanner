package sini.foxy.furscanner.animals

import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes

open class AnimalInterface(idPair: IdPair,location: Location, mode: Modes) {
    var sampoId = idPair.first
    var birthFarm = idPair.second
    var houseNumber: String = location.house
    var cageNumber = location.cage
    val gender =""
    val mode : Modes = mode
    fun getIDPair() = IdPair(sampoId,birthFarm)

}