package sini.foxy.furscanner.UI.Adapter

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.R
import sini.foxy.furscanner.UI.Fragment.PrevFrag
import sini.foxy.furscanner.animals.AbstractAnimal

/*!
Manages the recycler list in prev fragment
TODO: taking a prev fragment in constructor is bad habit for laajennettavuus
 */
class CustomRecyclerAdapter(private val mData : List<AbstractAnimal>, prevFragment : PrevFrag) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {
    private lateinit var alertDialog: AlertDialog
    private var prevFragment : PrevFrag = prevFragment
    inner class ViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView){
        val farmLabelName: TextView = itemView.findViewById(R.id.item_farm_and_id_FarmLabel)
         val idLabelName: TextView = itemView.findViewById(R.id.item_farm_and_id_IDLabel)
        val cageLabelName : TextView= itemView.findViewById(R.id.item_farm_and_id_CageLabel)
        val houseLabelName : TextView = itemView.findViewById(R.id.item_farm_and_id_HouseLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_farm_and_id, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position

        var testAnimal = mData.get(position)


        // Set item views based on your views and data model
        viewHolder.houseLabelName.setText(testAnimal.getLocation().house.toString())
        viewHolder.houseLabelName.setOnClickListener{
         prevFragment.showDialog(testAnimal)
    }
        viewHolder.cageLabelName.setText(testAnimal.getLocation().cage.toString())

        viewHolder.cageLabelName.setOnClickListener{
            prevFragment.showDialog(testAnimal)
        }
        viewHolder.idLabelName.setText(testAnimal.getIDPair().second)
        viewHolder.idLabelName.setOnClickListener{
            prevFragment.showDialog(testAnimal)
        }
        viewHolder.farmLabelName.setText(testAnimal.getIDPair().first)
        viewHolder.farmLabelName.setOnClickListener{
            prevFragment.showDialog(testAnimal)
        }

    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        println("Total item count is " + mData.size.toString())
        return mData.size
    }


}