package sini.foxy.furscanner.model.Listeners

abstract class AbstractObserver(var observable: AbstractObservable){
    abstract fun onUpdate()


}