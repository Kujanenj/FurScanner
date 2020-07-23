package sini.foxy.furscanner.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.R

class TestRecyclerAdapter(private val mData : List<IdPair>) : RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.contact_name)
        val messageButton = itemView.findViewById<Button>(R.id.message_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRecyclerAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_test, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: TestRecyclerAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val idPair : IdPair = mData.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.setText(idPair.first)
        val button = viewHolder.messageButton

    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mData.size
    }
}