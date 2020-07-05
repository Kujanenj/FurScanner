package sini.foxy.furscanner

import android.content.Context

class XMLStringFormer(context: Context) {
     val context : Context = context


    fun formXMLFile() : String {

    return formHeaderXML()

    }
    private fun formHeaderXML() : String {
        var header = context.getString(R.string.app_info_top)
        header = header.replace("SESSION_NUMBER",generalData.SessionNumber.toString())
        header = header.replace("DATE",generalData.Date.toString())
        //TODO : replace currentGender
        header.replace("CURRENT_LOC",formLocationXML(true))

        return header

    }

    private fun formBreedXML () : String{
            return ""
    }
    private fun formLocationXML(isCurrentLocation : Boolean) : String {
        var location = context.getString(R.string.current_location)
        if(isCurrentLocation){
            location= location.replace("Location","CurrentLocation")
        }

        location = location.replace("HOUSE_CAGE_LOC",formCageHouseXML())
        location = location.replace("INCREMENTATION",formIncrementationXML())

        return location
    }

    private fun formCageHouseXML() : String {


        var cageLoc = context.getString(R.string.house_cage_loc)

        cageLoc = cageLoc.replace("HOUSE_NUMBER",Location.HouseNumber.toString())

        cageLoc = cageLoc.replace("CAGE_NUMBER",Location.CageNumber.toString())


        println(cageLoc)
        return cageLoc
    }

    private fun formIncrementationXML(): String {
       var incString : String = context.getString(R.string.incrementation)
        incString = incString.replaceFirst("INC_DIRECTION",Incrementation.Direction.toString())
        incString = incString.replaceFirst("INC_AMOUNT",Incrementation.Amount.toString())
        return incString
    }

    }

