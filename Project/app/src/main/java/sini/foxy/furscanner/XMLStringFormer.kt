package sini.foxy.furscanner

import android.content.Context

class XMLStringFormer(context: Context) {
     val context : Context = context
    lateinit var xmlDataCopy: Map<String, String>

    fun formXMLFile(xmlData : Map<String,String>) : String {
    xmlDataCopy = xmlData
    return formHeaderXML()

    }
    //TODO : replace currentGender
    private fun formHeaderXML() : String {
        val header = context.getString(R.string.app_info_top,
            xmlDataCopy["SESSION_NUMBER"],
            xmlDataCopy["DATE"],
            formLocationXML(true))
        println("Header-->")
        println(header)
        return header

    }

    private fun formBreedXML (listOfAnimals : List<IdPair>) : String{
        var breedingAnimalStringSingle =""
            for (pair in listOfAnimals){
                breedingAnimalStringSingle+=context.getString(R.string.breeding_animal_single,pair.second,pair.first)
            }
        return context.getString(R.string.breeding_animals,breedingAnimalStringSingle)

    }
    private fun formLocationXML(isCurrentLocation : Boolean) : String {
        var location = context.getString(R.string.location,
            formCageHouseXML(),
            formIncrementationXML())
        if(isCurrentLocation){
            location= location.replace("Location","CurrentLocation")
        }
        return location
    }

    private fun formCageHouseXML() = context.getString(R.string.house_cage_loc,
        xmlDataCopy["HOUSE_NUMBER"],
        xmlDataCopy["CAGE_NUMBER"])
    private fun formIncrementationXML() = context.getString(R.string.incrementation,
            xmlDataCopy["DIRECTION"],
            xmlDataCopy["AMOUNT"])
    }

