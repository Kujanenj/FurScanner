package sini.foxy.furscanner.UI.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import sini.foxy.furscanner.R

/**
 * Fragment displaying the ID pair
 */
class FarmAndIDFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_farm_and_id, container, false)
    }

}
