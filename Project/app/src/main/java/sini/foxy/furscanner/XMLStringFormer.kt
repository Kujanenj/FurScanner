package sini.foxy.furscanner

import android.content.Context

class XMLStringFormer(context: Context) {
     val context : Context = context

    private lateinit var dataBase : DataBase
    //TODO: can't have x amount of parametres. Use a container instead?
    fun formXMLFile(dataBaseP: DataBase) : String {
    dataBase = dataBaseP
    return formHeaderXML()+formBreedXML()

    }
    //TODO : replace currentGender
    private fun formHeaderXML() : String {
        val header = context.getString(R.string.app_info_top,
            dataBase.getXMLDataMap()["SESSION_NUMBER"],
            dataBase.getXMLDataMap()["DATE"],
            formLocationXML(true))

        return header

    }

    private fun formBreedXML () : String{
        var breedingAnimalStringSingle =""
            for (pair in dataBase.getBreedContainer()){
                breedingAnimalStringSingle+=context.getString(R.string.breeding_animal_single,
                    pair.second,
                    pair.first,
                formLocationXML(false))
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
        dataBase.getXMLDataMap()["HOUSE_NUMBER"],
        dataBase.getXMLDataMap()["CAGE_NUMBER"])
    private fun formIncrementationXML() = context.getString(R.string.incrementation,
            dataBase.getXMLDataMap()["DIRECTION"],
            dataBase.getXMLDataMap()["AMOUNT"])
    }

