package sini.foxy.furscanner


class Controller {
    var currentMode : Modes = Modes.NO_MODE
    private val dataBase = DataBase()
    val parser =  Parser()

    public fun setMode(newMode : Modes ) : Boolean{

        currentMode =  newMode
        return true
    }


}