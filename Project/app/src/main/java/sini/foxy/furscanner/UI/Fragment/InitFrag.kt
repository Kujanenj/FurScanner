package sini.foxy.furscanner.UI.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch
import belka.us.androidtoggleswitch.widgets.ToggleSwitch
import sini.foxy.furscanner.model.Listeners.CustomTextWatcher

import sini.foxy.furscanner.R
import sini.foxy.furscanner.model.DataBaseManager
import sini.foxy.furscanner.model.Listeners.AbstractObservable
import sini.foxy.furscanner.model.Listeners.InterfaceObserver
import java.lang.Exception

/**
 * Fragement for setting up initial state of scanning
 */
class InitFrag(override var observable : AbstractObservable) :  AbstractPasserFragment(), InterfaceObserver{

    private lateinit var houseTextEditor: EditText
    private lateinit var cageTextEditor : EditText
    private lateinit var incrementTextEditor : EditText
    private lateinit var directionSwitch : ToggleSwitch
    private var dontModifyFlag = false
    var dataBase = observable as DataBaseManager
    override fun onUpdate() {
        try {
            dontModifyFlag = true //TODO: Kinda GONA solution
           // dataBase.removeObserver(this) //remove observer so no loop update is triggered
            houseTextEditor.setText((dataBase.getLocation().house).toString())
            cageTextEditor.setText((dataBase.getLocation().cage).toString())
            incrementTextEditor.setText(dataBase.getLocation().incAmount.toString())
            dontModifyFlag= false
            //TODO: Increment direction here
            //dataBase.addObserver(this)
        }
        catch (error : Exception){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase.addObserver(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*! Inflate the layout for this fragment
        and setup onAction listeners
        */
        val view = inflater.inflate(R.layout.fragment_init, container, false)
        houseTextEditor = view.findViewById(R.id.houseEditText)
        houseTextEditor.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(!dontModifyFlag) {
                    passData("house", houseTextEditor.text.toString())
                }
            }
        })

        cageTextEditor = view.findViewById(R.id.cageEditText)
        cageTextEditor.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(!dontModifyFlag) {
                passData("cage",cageTextEditor.text.toString())
            }}
        })

         incrementTextEditor = view.findViewById(R.id.incrementEditText)
        incrementTextEditor.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(!dontModifyFlag) {
                passData("incA",incrementTextEditor.text.toString())
            }}
        })
         directionSwitch = view.findViewById(R.id.switchButton)
        directionSwitch.setOnToggleSwitchChangeListener(object :BaseToggleSwitch.OnToggleSwitchChangeListener{
            override fun onToggleSwitchChangeListener(position : Int, isChecked : Boolean){

               passData("incD",directionSwitch.checkedTogglePosition.toString())
            }
        })

       return view
    }



}
