package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.*
import sini.foxy.furscanner.animals.AnimalFactory


class DataBaseTests {
    private val testDataBase : DataBaseManager = DataBaseManager(testSessionNumber, testDateTime)
    @Test
    fun testModifyDataBase(){
        Assert.assertEquals(1,testDataBase.modifyDataBase(testAnimal))
    }
    @Test
    fun testAddExistingAnimal(){
        Assert.assertEquals(1,testDataBase.modifyDataBase(testAnimal))
        Assert.assertEquals(-1,testDataBase.modifyDataBase(testAnimal))
    }
    @Test
    fun addAnimalWithSameID(){
        Assert.assertEquals(1,testDataBase.modifyDataBase(AnimalFactory.createAnimal(Modes.BREED,
            IdPair("10","10"),
            testLocation
       )))
        Assert.assertEquals(-1,testDataBase.modifyDataBase(AnimalFactory.createAnimal(Modes.BREED,
            IdPair("10","10"),
            testLocation
        )))
    }

    @Test
    fun testRandomDataBase10(){
        Assert.assertEquals(10, getPopulatedDataBaseManager(10,Modes.BREED).getDataBase().getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase100(){
        Assert.assertEquals(100, getPopulatedDataBaseManager(100,Modes.BREED).getDataBase().getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase1000(){
        Assert.assertEquals(1000, getPopulatedDataBaseManager(1000,Modes.BREED).getDataBase().getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase10000(){
        Assert.assertEquals(10000, getPopulatedDataBaseManager(10000,Modes.BREED).getDataBase().getBreedContainer().size)
    }

}