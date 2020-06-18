package sini.foxy.furscanner

import java.io.File
import java.lang.Exception

class FileWriterConcrete : FileWriterInterface{
    lateinit var wFile : File
    override fun appendFile(filePath: String?, contents: String) {
        initFile(filePath)
            wFile.appendText(contents)

    }

    override fun writeFile(filePath: String?, contents: String) {
        initFile(filePath)
        wFile.writeText(contents)
    }
    private fun initFile(filePath: String?){
        if(filePath==null){
            throw Exception("Error in WRITE FILE, filepath")
        }
        wFile = File(filePath) //TODO, this might not work
        wFile.createNewFile() // TODO, this too :/
    }
}