package sini.foxy.furscanner.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.R

class CustomRecyclerAdapter(private val mData : List<IdPair>) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView){
        val farmLabelName = itemView.findViewById<TextView>(R.id.FarmLabel)
         val idLablelName = itemView.findViewById<TextView>(R.id.IDLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_farm_and_id, parent, false)
        // Return a new holder instance
        println(mData)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position
        println("Position " + position.toString() + "has data of " + mData.get(position).first)
        val idPair : IdPair = mData.get(position)
        // Set item views based on your views and data model
        val farmTextView = viewHolder.farmLabelName
        farmTextView.setText(idPair.first)
        val idTextView = viewHolder.idLablelName
        idTextView.setText(idPair.second)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        println("Total item count is " + mData.size.toString())
        return mData.size
    }
}