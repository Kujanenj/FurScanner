package sini.foxy.furscanner

import android.content.Context

class XMLStringFormer(context: Context) {
     val context : Context = context


    fun formXMLFile() : String {

    return formHeaderXML()

    }
    //TODO : replace currentGender
    private fun formHeaderXML() : String {
        val header = context.getString(R.string.app_info_top,
            generalData.SessionNumber.data,
            generalData.Date.data,
            formLocationXML(true))
        println("Header-->")
        println(header)
        return header

    }

    private fun formBreedXML () : String{
            return ""
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
        Location.HouseNumber.data,
        Location.CageNumber.data)
    private fun formIncrementationXML() = context.getString(R.string.incrementation,
        Incrementation.Direction.data,
        Incrementation.Amount.data)
    }

