package sini.foxy.furscanner.UI.Fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import sini.foxy.furscanner.R
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter
import sini.foxy.furscanner.animals.AbstractAnimal

/**
 *  Shows the previous scan results
 */
class PrevFrag(var dataList : List<AbstractAnimal>) : AbstractPasserFragment() {

    private lateinit var alertDialog: AlertDialog
    private lateinit var adapter : CustomRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prev, container, false)
        val recycler  = view.findViewById<View>(R.id.testRecyclerView) as RecyclerView
        adapter = CustomRecyclerAdapter(dataList,this)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        passAdapter(adapter)
        return view
    }


    fun showDialog() {
        val inflater: LayoutInflater = this.getLayoutInflater()
        val dialogView: View = inflater.inflate(R.layout.test_alert, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        dialogBuilder.setOnDismissListener(object : DialogInterface.OnDismissListener {
            override fun onDismiss(arg0: DialogInterface) {

            }
        })

        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create()
        // alertDialog.window!!.getAttributes().windowAnimations = R.style.PauseDialogAnimation
        alertDialog.show()
    }

}
