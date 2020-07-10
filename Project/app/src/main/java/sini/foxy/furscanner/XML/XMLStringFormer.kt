package sini.foxy.furscanner.XML

import android.content.Context
import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.xml

class XMLStringFormer(context: Context) {


val TESTAPPXML = AppInfoXML("-",
    "-",
    "-",
    "-",
    "-",
    "-",
    "-",
    "-",
    "-",
    "-",
    "-")
val AppInfoTop = xml("Session"){
    xmlns = "http://www.w3.org/2001/XMLSchema-instance xmlns:xsd=http://www.w3.org/2001/XMLSchema" //TODO: This is wrong
    "ApplicationVersion"{
        -TESTAPPXML.ApplicationVersion
    }
    "Number"{
        -TESTAPPXML.Number
    }
    "Created"{
        -TESTAPPXML.Created
    }
    "Modified"{
        -TESTAPPXML.Modified
    }
    "HasChanges"{
        -TESTAPPXML.HasChanges
    }
    "CurrentlyUsedGradingvalues"{
        -TESTAPPXML.Modified
    }
    "GenderReset"{
        -TESTAPPXML.GenderReset
    }
    "CurrentGender"   {
        -TESTAPPXML.CurrentGender
    }
    "CurrentLocation"{
        -TESTAPPXML.CurrentLocation
    }
    "AnimalGradings" {
        -TESTAPPXML.AnimalGradings
    }
    "BreedingAnimals" {
        -TESTAPPXML.BreedingAnimals
    }
}


    fun createTest() = AppInfoTop.toString(PrintOptions(singleLineTextElements = true))
}

