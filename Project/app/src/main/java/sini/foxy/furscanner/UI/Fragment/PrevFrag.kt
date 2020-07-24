package sini.foxy.furscanner.UI.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair

import sini.foxy.furscanner.R
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter
import sini.foxy.furscanner.model.RandomGenerator

/**
 *  Shows the previous scan results
 */
class PrevFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val randomGenerator = RandomGenerator()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prev, container, false)
        val recycler  = view.findViewById<View>(R.id.testRecyclerView) as RecyclerView
        val adapter = CustomRecyclerAdapter(
            randomGenerator.getIdPairList(3).reversed()
        )
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        return view
    }

}
