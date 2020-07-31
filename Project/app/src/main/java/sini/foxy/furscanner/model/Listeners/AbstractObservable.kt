package sini.foxy.furscanner.model.Listeners

import java.lang.Exception

abstract class AbstractObservable() {
    private var registeredObserves  = mutableListOf<InterfaceObserver>()
    fun addObserver(observer : InterfaceObserver){
        if(!registeredObserves.contains(observer)){
            registeredObserves.add(observer)
        }
        else{
            throw Exception("Observer already contained in list") //Todo: Better type of exception?
        }
    }
    fun removeObserver(observer: InterfaceObserver){
        registeredObserves.remove(observer) //Todo: Safety Checks?
    }

    fun updateObservers(){
        for (observer in registeredObserves){
            observer.onUpdate()
        }
    }
}