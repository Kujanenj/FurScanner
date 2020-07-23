package sini.foxy.furscanner.UI.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import sini.foxy.furscanner.UI.Fragment.initFrag
import sini.foxy.furscanner.UI.Fragment.prevFrag
import sini.foxy.furscanner.UI.Fragment.scanFrag

class MyPagerAdapter (fragManager: FragmentManager) : FragmentPagerAdapter(fragManager) {
    private val tabAmount : Int= 3
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                initFrag()
            }
            1 -> scanFrag()
            else -> {
                return prevFrag()
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
