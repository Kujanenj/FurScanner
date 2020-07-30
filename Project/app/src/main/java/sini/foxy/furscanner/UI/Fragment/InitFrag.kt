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

/**
 * Fragement for setting up initial state of scanning
 */
class InitFrag :  AbstractPasserFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ASDASD")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*! Inflate the layout for this fragment
        and setup onAction listeners
        */
        val view = inflater.inflate(R.layout.fragment_init, container, false)
        val houseTextEditor = view?.findViewById<EditText>(R.id.houseEditText)
        houseTextEditor?.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                passData("house",houseTextEditor.text.toString())
            }
        })

        val cageTextEditor = view?.findViewById<EditText>(R.id.cageEditText)
        cageTextEditor?.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                passData("cage",cageTextEditor.text.toString())
            }
        })

        val incrementTextEditor = view?.findViewById<EditText>(R.id.incrementEditText)
        incrementTextEditor?.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                passData("incA",incrementTextEditor.text.toString())
            }
        })
        val testSwitch = view?.findViewById<ToggleSwitch>(R.id.switchButton)
        testSwitch?.setOnToggleSwitchChangeListener(object :BaseToggleSwitch.OnToggleSwitchChangeListener{
            override fun onToggleSwitchChangeListener(position : Int, isChecked : Boolean){

               passData("incD",testSwitch.checkedTogglePosition.toString())
            }
        })

       return view
    }



}
