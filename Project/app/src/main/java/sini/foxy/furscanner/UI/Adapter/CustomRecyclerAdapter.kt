package sini.foxy.furscanner.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.R
import sini.foxy.furscanner.animals.AbstractAnimal

/*!
Manages the recycler list in prev fragment
 */
class CustomRecyclerAdapter(private val mData : List<AbstractAnimal>) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView){
        val farmLabelName: TextView = itemView.findViewById(R.id.FarmLabel)
         val idLabelName: TextView = itemView.findViewById(R.id.IDLabel)
        val cageLabelName : TextView= itemView.findViewById(R.id.testCageLabel)
        val houseLabelName : TextView = itemView.findViewById(R.id.testHouseLabel)
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
        viewHolder.cageLabelName.setText(testAnimal.getLocation().cage.toString())
        viewHolder.idLabelName.setText(testAnimal.getIDPair().first)
        viewHolder.farmLabelName.setText(testAnimal.getIDPair().second)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        println("Total item count is " + mData.size.toString())
        return mData.size
    }
}