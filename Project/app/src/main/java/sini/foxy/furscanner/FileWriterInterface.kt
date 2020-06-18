package sini.foxy.furscanner

interface FileWriterInterface {


    fun appendFile(filePath : String?, contents : String)
    fun writeFile(filePath : String?, contents : String)
}