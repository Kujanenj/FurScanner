package sini.foxy.furscanner.UI.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import sini.foxy.furscanner.R
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter
import sini.foxy.furscanner.animals.AbstractAnimal

/**
 *  Shows the previous scan results
 */
class PrevFrag(var dataList : List<AbstractAnimal>) : AbstractPasserFragment() {

    private lateinit var adapter : CustomRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prev, container, false)
        val recycler  = view.findViewById<View>(R.id.testRecyclerView) as RecyclerView
         adapter = CustomRecyclerAdapter(dataList)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        passAdapter(adapter)
        return view
    }
}
