package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.makePopulatedDataBase
import sini.foxy.furscanner.testAnimal
import java.lang.Exception

class DataBaseTests {
    private val testDataBase : DataBaseManager = DataBaseManager()
    @Test
    fun testModifyDataBase(){
        Assert.assertEquals(true,testDataBase.modifyDataBase(testAnimal,Modes.BREED))
    }
    @Test
    fun testAddExistingAnimal(){
        Assert.assertEquals(true,testDataBase.modifyDataBase(testAnimal,Modes.BREED))
        Assert.assertEquals(false,testDataBase.modifyDataBase(testAnimal,Modes.BREED))}
    @Test
    fun testRandomDataBase10(){
        Assert.assertEquals(10, makePopulatedDataBase(10,Modes.BREED).getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase100(){
        Assert.assertEquals(100, makePopulatedDataBase(100,Modes.BREED).getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase1000(){
        Assert.assertEquals(1000, makePopulatedDataBase(1000,Modes.BREED).getBreedContainer().size)
    }
    @Test
    fun testRandomDataBase10000(){
        Assert.assertEquals(10000, makePopulatedDataBase(10000,Modes.BREED).getBreedContainer().size)
    }

}