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

/**
 * A simple [Fragment] subclass.
 */
class prevFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prev, container, false)
        val recycler  = view.findViewById<View>(R.id.testRecyclerView) as RecyclerView
        val adapter = CustomRecyclerAdapter(
            listOf(
                IdPair("0", "123123"), IdPair("1", "114144"),
                IdPair("2", "00")
            )
        )
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        return view
    }

}
