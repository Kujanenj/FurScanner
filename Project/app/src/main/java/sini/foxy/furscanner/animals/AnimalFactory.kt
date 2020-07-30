package sini.foxy.furscanner.animals

import sini.foxy.furscanner.Exception.IllegalModeException
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes
import java.lang.Exception


/*!
Class for creating different kind of animals
 */
class AnimalFactory {


    companion object AnimalCreation {
        fun createAnimal(mode : Modes,idPair: IdPair,location: Location ): AbstractAnimal = when(mode){
            Modes.BREED -> BreedingAbstractAnimal(idPair,location,mode)
            Modes.NO_MODE -> throw IllegalModeException(Modes.NO_MODE,"AnimalFactory.createAnimal")
        }



    }
}