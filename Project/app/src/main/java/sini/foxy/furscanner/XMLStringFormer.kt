package sini.foxy.furscanner

import android.content.Context

class XMLStringFormer(context: Context) {
     val context : Context = context


    fun formXMLFile() : String {

    return formHeaderXML()

    }
    private fun formHeaderXML() : String {
        var header = context.getString(R.string.app_info_top)
        header = header.replace("SESSION_NUMBER",generalData.SessionNumber.data)
        header = header.replace("DATE",generalData.Date.data)
        //TODO : replace currentGender
        header = header.replace("CURRENT_LOC",formLocationXML(true))
        println("Header-->")
        println(header)
        return header

    }

    private fun formBreedXML () : String{
            return ""
    }
    private fun formLocationXML(isCurrentLocation : Boolean) : String {
        var location = context.getString(R.string.location)
        if(isCurrentLocation){
            location= location.replace("Location","CurrentLocation")
        }

        location = location.replace("HOUSE_CAGE_LOC",formCageHouseXML())
        location = location.replace("INCREMENTATION",formIncrementationXML())

        return location
    }

    private fun formCageHouseXML() : String {


        var cageLoc = context.getString(R.string.house_cage_loc)

        cageLoc = cageLoc.replace("HOUSE_NUMBER",Location.HouseNumber.data)

        cageLoc = cageLoc.replace("CAGE_NUMBER",Location.CageNumber.data)


        return cageLoc
    }

    private fun formIncrementationXML(): String {
       var incString : String = context.getString(R.string.incrementation)
        incString = incString.replaceFirst("INC_DIRECTION",Incrementation.Direction.data)
        incString = incString.replaceFirst("INC_AMOUNT",Incrementation.Amount.data)

        return incString
    }

    }

