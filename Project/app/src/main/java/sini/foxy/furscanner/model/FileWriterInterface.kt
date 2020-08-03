package sini.foxy.furscanner.model

interface FileWriterInterface {


    fun appendFile(filePath : String?, contents : String)
    fun writeFile(filePath : String?, contents : String)

    fun readTestFile(filePath: String?)
}