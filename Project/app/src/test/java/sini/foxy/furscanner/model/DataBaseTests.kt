package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.*


class DataBaseTests {
    private val testDataBase : DataBaseManager = DataBaseManager(testSessionNumber, testDateTime)
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