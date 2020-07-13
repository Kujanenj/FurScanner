package sini.foxy.furscanner.animals

import org.junit.Test

import org.junit.Assert.*
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.Location
import sini.foxy.furscanner.Modes

class AnimalFactoryTests {
    @Test
    fun testCreateAnimal(){
        val testLocation = Location("1","2","ASC","2")
        val testID = IdPair("604418","5302")
        val testAnimal = AnimalFactory.createAnimal(Modes.BREED,testID,testLocation
        )
        assertEquals("BREED",testAnimal.getAnimalType())
        assertEquals(testAnimal.getLocation(),testLocation)
        assertEquals(testAnimal.getIDPair(),testID)
    }
}