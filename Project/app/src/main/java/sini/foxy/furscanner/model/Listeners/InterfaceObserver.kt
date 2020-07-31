package sini.foxy.furscanner.model.Listeners

interface InterfaceObserver{
    var observable : AbstractObservable
    fun onUpdate()
}