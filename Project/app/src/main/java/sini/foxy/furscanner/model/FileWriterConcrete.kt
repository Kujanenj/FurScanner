package sini.foxy.furscanner.model

import android.content.Context
import java.io.File
import java.lang.Exception

class FileWriterConcrete : FileWriterInterface {
    lateinit var wFile : File
    override fun appendFile(filePath: String?, contents: String) {
        initFile(filePath)
            wFile.appendText(contents)

    }

    override fun writeFile(filePath: String?, contents: String) {

        println(filePath)
        initFile(filePath)
        wFile.writeText(contents)
        println("Wrote some stuff to filepath; $filePath")

    }
    private fun initFile(filePath: String?){
        if(filePath==null){
            throw Exception("Error in WRITE FILE, filepath")
        }
        wFile = File(filePath) //TODO, this might not work
        wFile.createNewFile() // TODO, this too :/
    }

    override fun readTestFile(filePath: String?) {
        val rFile = File(filePath)
        println(rFile.readLines())
    }
}