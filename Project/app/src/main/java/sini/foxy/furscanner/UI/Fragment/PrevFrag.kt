package sini.foxy.furscanner.UI.Fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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

    //TODO: Replace repetitive code with custom on listener class
    //TODO: Handle empty inputs
    fun showDialog(animalToModify : AbstractAnimal) {

        val indexOfAnimalToModify = dataList.indexOf(animalToModify)
        val inflater: LayoutInflater = this.getLayoutInflater()
        val dialogView: View = inflater.inflate(R.layout.test_alert, null)
        val layoutLower = dialogView.findViewById<View>(R.id.alert_layout_lower)
        val sampoIDLabelLower= layoutLower.findViewById<EditText>(R.id.item_farm_and_id_editable_IDLabel)
        sampoIDLabelLower.setText(animalToModify.sampoId)
        sampoIDLabelLower?.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                animalToModify.sampoId=sampoIDLabelLower.text.toString()
                notifyAdapter(indexOfAnimalToModify)
            }
        })
        val farmLabelLower = layoutLower.findViewById<EditText>(R.id.item_farm_and_id_editable_FarmLabel)
        farmLabelLower.setText(animalToModify.birthFarm)
        farmLabelLower?.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                    animalToModify.birthFarm = farmLabelLower.text.toString()
                    notifyAdapter(indexOfAnimalToModify)

            }
        })
        val houseLabelLower  =layoutLower.findViewById<EditText>(R.id.item_farm_and_id_editable_HouseLabel)
        houseLabelLower.setText(animalToModify.getLocation().house.toString())
        houseLabelLower?.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            animalToModify.getLocation().house=(houseLabelLower.text.toString()).toInt()
                notifyAdapter(indexOfAnimalToModify)
            }
        })
        val cageLabelLower = layoutLower.findViewById<EditText>(R.id.item_farm_and_id_editable_CageLabel)
        cageLabelLower.setText(animalToModify.getLocation().cage.toString())
        cageLabelLower?.addTextChangedListener(object : TextWatcher {


            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                animalToModify.getLocation().cage=(cageLabelLower.text.toString().toInt())
                notifyAdapter(indexOfAnimalToModify)
            }
        })
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
    fun notifyAdapter(index : Int){
        adapter.notifyItemChanged(index)
    }
}
