package sini.foxy.furscanner.XML


import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.xml
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.model.DataBase
import sini.foxy.furscanner.model.DataBaseManager

class XMLStringFormer() {

    fun makeXML(dataBaseManager: DataBaseManager) : String{
        println("Forming XML string")


        val AppInfoTop = xml("Session"){
            globalProcessingInstruction("xml","version" to "1.0")
            attributes(Pair("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance"),Pair("xmlns:xsd","http://www.w3.org/2001/XMLSchema"))
            "ApplicationVersion"{
                -""
            }
            "Number"{
                -dataBaseManager.getXMLData()["SESSION_NUMBER"]!!
            }
            "Created"{
                -dataBaseManager.getDateTime()
            }
            "Modified"{
                -dataBaseManager.getDateTime()
            }
            "HasChanges"{
                -dataBaseManager.getXMLData()["HAS_CHANGES"]!!
            }
            "CurrentlyUsedGradingValues"{
            }
            "GenderReset"{
                -dataBaseManager.getXMLData()["GENDER_RESET"]!!
            }
            "CurrentGender"   {
                -dataBaseManager.getXMLData()["CURRENT_GENDER"]!!
            }
            "CurrentLocation"{
                    "HouseNumber"{
                        -dataBaseManager.getLocation().house.toString()
                    }
                    "CageNumber"{
                        -dataBaseManager.getLocation().cage.toString()
                    }
                    "IncrementDirection"{
                        -dataBaseManager.getLocation().incDir
                    }
                    "IncrementAmount"{
                        -dataBaseManager.getLocation().incAmount.toString()
                    }
            }
            "AnimalGradings" {

            }
            "BreedingAnimals" {

                for (animal in dataBaseManager.getContainer(Modes.BREED)){

                    "BreedingAnimal"{
                        "AnimalId"{
                            "BirthFarm"{
                                -animal.birthFarm
                            }
                            "SampoId"{
                                -animal.sampoId
                            }
                        }
                        "Gender"{
                            -animal.gender
                        }
                        "AnimalType"{
                            attribute("xsi:type","NullAnimalType")
                        "Language"{
                            -"Unknown"
                        }
                        "AnimalSpecies"{
                            attribute("xsi:type","NullAnimalSpecies")
                            "Code"{
                                -"-1"
                            }
                            "Abbreviation"{
                                -"-"
                            }
                        }
                            "AnimalTypeGroup"{
                                attribute("xsi:type","NullAnimalTypeGroup")
                                "Code"{
                                    -"-1"
                                }
                                "Abbreviation"{
                                    -"-"
                                }
                            }
                        "Name"{
                            -"-"
                        }
                        "Description"{
                            -"-"
                        }
                        }
                        "Location"{
                            "HouseNumber"{
                                -animal.getLocation().house.toString()
                            }
                            "CageNumber"{
                                -animal.getLocation().cage.toString()
                            }
                            "IncrementDirection"{
                                -animal.getLocation().incDir
                            }
                            "IncrementAmount"{
                                -animal.getLocation().incAmount.toString()
                            }
                        }
                        "Gradings"{

                        }
                    }
                }
            }
            "LastSavedPairingDate"{
                -dataBaseManager.getDateTime()
            }
            "LastSavedPairingMethod"{
                -"Pairing"
            }
            "Pairings"{

            }
            "LastSavedWhelpingDate"{
                -dataBaseManager.getDateTime()
            }
            "LastSavedWhelpingMethod"{
                -"Normal"
            }
            "Whelpings"{

            }
            "RunningTotalCount"{
                -"0"
            }
            "RunningNumberOfTheCount"{
                -"0"
            }
            "RunningMaleCount"{
                -"0"
            }
            "RunningFemaleCount"{
                -"0"
            }
            "LitterCounts"{

            }
            "FurfixLinks"{

            }
            "Groups"{

            }
            "Syncronizations"{

            }
            "LastSavedFirstPairingDate"{
                -dataBaseManager.getDateTime()
            }
            "LastSavedSecondPairingDate"{
                -dataBaseManager.getDateTime()
            }
            "LastSavedThirdPairingDate"{
                -dataBaseManager.getDateTime()
            }
            "WizardLaps"{

            }
            "ApplicationErrors"{

            }
            "IsDeserializing"{
                -"false"
            }

        }

        return AppInfoTop.toString(PrintOptions(true,true))
    }
}

