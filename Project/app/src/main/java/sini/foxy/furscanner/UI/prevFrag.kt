package sini.foxy.furscanner.UI

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sini.foxy.furscanner.IdPair

import sini.foxy.furscanner.R

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
        val adapter = TestRecyclerAdapter(listOf(IdPair("13","13"),IdPair("14","14")))
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        return view
    }

}
