package sini.foxy.furscanner.UI


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch
import belka.us.androidtoggleswitch.widgets.ToggleSwitch

import sini.foxy.furscanner.MainActivity
import sini.foxy.furscanner.OnDataPass

import sini.foxy.furscanner.R

/**
 * A simple [Fragment] subclass.
 */
class initFrag : Fragment() {
    lateinit var dataPasser : OnDataPass
    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser= context as OnDataPass
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_init, container, false)
        val houseTextEditor = view?.findViewById<EditText>(R.id.houseEditText)
        houseTextEditor?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                passData(houseTextEditor.text.toString())
            }
        })

        val cageTextEditor = view?.findViewById<EditText>(R.id.cageEditText)
        cageTextEditor?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                passData(cageTextEditor.text.toString())
            }
        })

        val incrementTextEditor = view?.findViewById<EditText>(R.id.cageEditText)
        incrementTextEditor?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                passData(incrementTextEditor.text.toString())
            }
        })

      


       return view
    }


    fun passData(someData : String){
        dataPasser.onDataPass(someData)
    }
}
