package sini.foxy.furscanner.XML


import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.xml
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.model.DataBase
import sini.foxy.furscanner.model.DataBaseManager

class XMLStringFormer() {

    fun makeXML(dataBaseManager: DataBaseManager) : String{
        println("Forming XML string")
        println(dataBaseManager.getContainer(Modes.BREED).size)
       val generalData = dataBaseManager.getXMLData()

        val AppInfoTop = xml("Session"){
            globalProcessingInstruction("xml","version" to "1.0")
            attributes(Pair("xmlns:xsd","http://www.w3.org/2001/XMLSchema"),Pair("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance"))
            "ApplicationVersion"{
                -""
            }
            "Number"{
                -generalData["SESSION_NUMBER"]!!
            }
            "Created"{
                -generalData["DATE"]!!
            }
            "Modified"{
                -generalData["DATE"]!!
            }
            "HasChanges"{
                -generalData["HAS_CHANGES"]!!
            }
            "CurrentlyUsedGradingValues"{
            }
            "GenderReset"{
                -generalData["GENDER_RESET"]!!
            }
            "CurrentGender"   {
                -generalData["CURRENT_GENDER"]!!
            }
            "CurrentLocation"{
                    "HouseNumber"{
                        -""
                    }
                    "CageNumber"{
                        -""
                    }
                    "IncrementDirection"{
                        -""
                    }
                    "IncrementAmount"{
                        -""
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
                -"PairingDate"
            }
            "LastSavedPairingMethod"{
                -""
            }
            "Pairings"{

            }
            "LastSavedWhelpingDate"{
                -"whelpDate"
            }
            "LastSavedWhelpingMethod"{
                -"whelpMethod"
            }
            "Whelpings"{

            }
            "RunningTotalCount"{
                -"RunningTotalCount"
            }
            "RunningNumberOfTheCount"{
                -"RunningSomething"
            }
            "RunningMaleCount"{
                -"DataHerePlease"
            }
            "RunningFemaleCount"{
                -"SomeMOreDataForMe"
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
                -""
            }
            "LastSavedSecondPairingDate"{
                -""
            }
            "LastSavedThirdPairingDate"{
                -""
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

