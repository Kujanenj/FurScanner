package sini.foxy.furscanner.XML

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.Modes

import sini.foxy.furscanner.getPopulatedDataBaseManager
import sini.foxy.furscanner.testXMLFormer


class XMLStringFormerTest {
    @Test
    fun testFormStringBreed5(){
        Assert.assertEquals("<?xml version=\"1.0\"?>\n" +
                "<Session xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "  <ApplicationVersion>2.4.6361.20159</ApplicationVersion>\n" +
                "  <Number>12</Number>\n" +
                "  <Created>2020-06-13T11:07:13-08:00</Created>\n" +
                "  <Modified>2020-06-13T11:08:44-08:00</Modified>\n" +
                "  <HasChanges>true</HasChanges>\n" +
                "  <CurrentlyUsedGradingValues />\n" +
                "  <GenderReset>true</GenderReset>\n" +
                "  <CurrentGender>129</CurrentGender>\n" +
                "  <CurrentLocation>\n" +
                "    <HouseNumber>1</HouseNumber>\n" +
                "    <CageNumber>10</CageNumber>\n" +
                "    <IncrementDirection>Ascending</IncrementDirection>\n" +
                "    <IncrementAmount>2</IncrementAmount>\n" +
                "  </CurrentLocation>\n" +
                "  <AnimalGradings />\n" +
                "  <BreedingAnimals>\n" +
                "    <BreedingAnimal>\n" +
                "      <AnimalId>\n" +
                "        <BirthFarm>5302</BirthFarm>\n" +
                "        <SampoId>400721</SampoId>\n" +
                "      </AnimalId>\n" +
                "      <Gender>129</Gender>\n" +
                "      <AnimalType xsi:type=\"NullAnimalType\">\n" +
                "        <Language>Unknown</Language>\n" +
                "        <AnimalSpecies xsi:type=\"NullAnimalSpecies\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalSpecies>\n" +
                "        <AnimalTypeGroup xsi:type=\"NullAnimalTypeGroup\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalTypeGroup>\n" +
                "        <Name>-</Name>\n" +
                "        <Description>-</Description>\n" +
                "      </AnimalType>\n" +
                "      <Location>\n" +
                "        <HouseNumber>1</HouseNumber>\n" +
                "        <CageNumber>2</CageNumber>\n" +
                "        <IncrementDirection>Ascending</IncrementDirection>\n" +
                "        <IncrementAmount>2</IncrementAmount>\n" +
                "      </Location>\n" +
                "      <Gradings />\n" +
                "    </BreedingAnimal>\n" +
                "    <BreedingAnimal>\n" +
                "      <AnimalId>\n" +
                "        <BirthFarm>5302</BirthFarm>\n" +
                "        <SampoId>706881</SampoId>\n" +
                "      </AnimalId>\n" +
                "      <Gender>129</Gender>\n" +
                "      <AnimalType xsi:type=\"NullAnimalType\">\n" +
                "        <Language>Unknown</Language>\n" +
                "        <AnimalSpecies xsi:type=\"NullAnimalSpecies\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalSpecies>\n" +
                "        <AnimalTypeGroup xsi:type=\"NullAnimalTypeGroup\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalTypeGroup>\n" +
                "        <Name>-</Name>\n" +
                "        <Description>-</Description>\n" +
                "      </AnimalType>\n" +
                "      <Location>\n" +
                "        <HouseNumber>1</HouseNumber>\n" +
                "        <CageNumber>4</CageNumber>\n" +
                "        <IncrementDirection>Ascending</IncrementDirection>\n" +
                "        <IncrementAmount>2</IncrementAmount>\n" +
                "      </Location>\n" +
                "      <Gradings />\n" +
                "    </BreedingAnimal>\n" +
                "    <BreedingAnimal>\n" +
                "      <AnimalId>\n" +
                "        <BirthFarm>5302</BirthFarm>\n" +
                "        <SampoId>604429</SampoId>\n" +
                "      </AnimalId>\n" +
                "      <Gender>129</Gender>\n" +
                "      <AnimalType xsi:type=\"NullAnimalType\">\n" +
                "        <Language>Unknown</Language>\n" +
                "        <AnimalSpecies xsi:type=\"NullAnimalSpecies\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalSpecies>\n" +
                "        <AnimalTypeGroup xsi:type=\"NullAnimalTypeGroup\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalTypeGroup>\n" +
                "        <Name>-</Name>\n" +
                "        <Description>-</Description>\n" +
                "      </AnimalType>\n" +
                "      <Location>\n" +
                "        <HouseNumber>1</HouseNumber>\n" +
                "        <CageNumber>6</CageNumber>\n" +
                "        <IncrementDirection>Ascending</IncrementDirection>\n" +
                "        <IncrementAmount>2</IncrementAmount>\n" +
                "      </Location>\n" +
                "      <Gradings />\n" +
                "    </BreedingAnimal>\n" +
                "    <BreedingAnimal>\n" +
                "      <AnimalId>\n" +
                "        <BirthFarm>5302</BirthFarm>\n" +
                "        <SampoId>604408</SampoId>\n" +
                "      </AnimalId>\n" +
                "      <Gender>129</Gender>\n" +
                "      <AnimalType xsi:type=\"NullAnimalType\">\n" +
                "        <Language>Unknown</Language>\n" +
                "        <AnimalSpecies xsi:type=\"NullAnimalSpecies\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalSpecies>\n" +
                "        <AnimalTypeGroup xsi:type=\"NullAnimalTypeGroup\">\n" +
                "          <Code>-1</Code>\n" +
                "          <Abbreviation>-</Abbreviation>\n" +
                "        </AnimalTypeGroup>\n" +
                "        <Name>-</Name>\n" +
                "        <Description>-</Description>\n" +
                "      </AnimalType>\n" +
                "      <Location>\n" +
                "        <HouseNumber>1</HouseNumber>\n" +
                "        <CageNumber>8</CageNumber>\n" +
                "        <IncrementDirection>Ascending</IncrementDirection>\n" +
                "        <IncrementAmount>2</IncrementAmount>\n" +
                "      </Location>\n" +
                "      <Gradings />\n" +
                "    </BreedingAnimal>\n" +
                "  </BreedingAnimals>\n" +
                "  <LastSavedPairingDate>2020-06-13T00:00:00-08:00</LastSavedPairingDate>\n" +
                "  <LastSavedPairingMethod>Pairing</LastSavedPairingMethod>\n" +
                "  <Pairings />\n" +
                "  <LastSavedWhelpingDate>2020-06-13T00:00:00-08:00</LastSavedWhelpingDate>\n" +
                "  <LastSavedWhelpingMethod>Normal</LastSavedWhelpingMethod>\n" +
                "  <Whelpings />\n" +
                "  <RunningTotalCount>0</RunningTotalCount>\n" +
                "  <RunningNumberOfTheCount>0</RunningNumberOfTheCount>\n" +
                "  <RunningMaleCount>0</RunningMaleCount>\n" +
                "  <RunningFemaleCount>0</RunningFemaleCount>\n" +
                "  <LitterCounts />\n" +
                "  <FurfixLinks />\n" +
                "  <Groups />\n" +
                "  <Syncronizations />\n" +
                "  <LastSavedFirstPairingDate>0001-01-01T00:00:00</LastSavedFirstPairingDate>\n" +
                "  <LastSavedSecondPairingDate>0001-01-01T00:00:00</LastSavedSecondPairingDate>\n" +
                "  <LastSavedThirdPairingDate>0001-01-01T00:00:00</LastSavedThirdPairingDate>\n" +
                "  <WizardLaps />\n" +
                "  <ApplicationErrors />\n" +
                "  <IsDeserializing>false</IsDeserializing>\n" +
                "</Session>",testXMLFormer.makeXML(getPopulatedDataBaseManager(4,Modes.BREED).getDataBase()))
    }
}