package sini.foxy.furscanner.UI.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import sini.foxy.furscanner.IdPair
import sini.foxy.furscanner.UI.Fragment.InitFrag
import sini.foxy.furscanner.UI.Fragment.PrevFrag
import sini.foxy.furscanner.UI.Fragment.ScanFrag
import sini.foxy.furscanner.animals.AbstractAnimal
import sini.foxy.furscanner.model.DataBase

class MyPagerAdapter (fragManager: FragmentManager,val breedList : MutableList<AbstractAnimal>) : FragmentPagerAdapter(fragManager) {
    private val tabAmount : Int= 3
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                InitFrag()
            }
            1 -> ScanFrag()
            else -> {
                return PrevFrag(breedList)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Init"
            1 -> "Scan"
            else -> {
                return "Prev"
            }
        }
    }

        override fun getCount() = tabAmount
    }
