package sini.foxy.furscanner.XML


import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.xml
import sini.foxy.furscanner.model.DataBase

class XMLStringFormer() {

    fun makeXML(dataBase: DataBase) : String{
        println("Forming XML string")
        println(dataBase.getBreedContainer().size)
       val generalData = dataBase.getXMLDataMap()

        val AppInfoTop = xml("Session"){
            xmlns = "http://www.w3.org/2001/XMLSchema-instance xmlns:xsd=http://www.w3" +
                    ".org/2001/XMLSchema" //TODO: This is wrong
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
            "CurrentlyUsedGradingvalues"{
                -generalData["GRADING"]!!
            }
            "GenderReset"{
                -generalData["GENDER_RESET"]!!
            }
            "CurrentGender"   {
                -generalData["CURRENT_GENDER"]!!
            }
            "CurrentLocation"{
               -""
            }
            "AnimalGradings" {
              -""
            }
            "BreedingAnimals" {

                for ((id,animal) in dataBase.getBreedContainer()){

                    "BreedingAnimal"{
                        "AnimalID"{
                            "BirthFarm"{
                                -animal.birthFarm
                            }
                            "SampoID"{
                                -animal.sampoId
                            }
                        }
                        "Gender"{
                            -""
                        }
                        //"<AnimalType xsi:type=\"NullAnimalType\">"{ TODO: check formatting online
                        //}
                        "Languge"{

                        }
                        //TODO: Add animal species
                        "Code"{
                            -""
                        }
                        "Abbreviation"{

                        }
                        //TODO: add animal typegroup
                        "Code"{
                            -""
                        }
                        "Abbreviation"{
                            -""
                        }
                        "Name"{
                            -""
                        }
                        "Description"{

                        }
                        "Location"{
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
                    }
                }
            }
        }

        return AppInfoTop.toString(PrintOptions(true,true))
    }
}

