package sini.foxy.furscanner.UI.Fragment

import android.content.Context
import androidx.fragment.app.Fragment
import sini.foxy.furscanner.OnDataPass

abstract class AbstractPasserFragment : Fragment(){
       lateinit var dataPasser : OnDataPass
    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser= context as OnDataPass
    }
    fun passData(widgetID : String, data : String){
        dataPasser.onDataPass(Pair(widgetID,data))
    }

}