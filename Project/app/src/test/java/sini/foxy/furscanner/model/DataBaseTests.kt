package sini.foxy.furscanner.model

import org.junit.Assert
import org.junit.Test
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.animals.AnimalFactory
import sini.foxy.furscanner.testAnimal
import java.lang.Exception

class DataBaseTests {
    private val testDataBase : DataBaseManager = DataBaseManager()
    @Test
    fun testModifyDataBase(){
        testDataBase.modifyDataBase(testAnimal,Modes.BREED)
        Assert.assertEquals(1,testDataBase.getDataBase().getBreedContainer().size)
    }
    @Test
    fun testAddExistingAnimal(){
        testDataBase.modifyDataBase(testAnimal,Modes.BREED)
        Assert.assertEquals(1,testDataBase.getDataBase().getBreedContainer().size)
        testDataBase.modifyDataBase(testAnimal,Modes.BREED)
        Assert.assertEquals(1,testDataBase.getDataBase().getBreedContainer().size)

    }

}