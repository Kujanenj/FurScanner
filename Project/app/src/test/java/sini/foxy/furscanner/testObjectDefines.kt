package sini.foxy.furscanner

import sini.foxy.furscanner.animals.AnimalFactory

val testPair : IdPair = IdPair("604418","5302")
val testLocation : Location = Location("1","2","ASC","2")
val testAnimal = AnimalFactory.createAnimal(Modes.BREED, testPair, testLocation)