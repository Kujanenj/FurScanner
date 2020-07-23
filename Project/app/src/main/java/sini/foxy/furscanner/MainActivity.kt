package sini.foxy.furscanner

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import sini.foxy.furscanner.UI.Adapter.MyPagerAdapter
import sini.foxy.furscanner.model.RandomGenerator


//TODO : replace all test stuff with actual implementations
//DESKTOP-06IBLMI
class MainActivity : AppCompatActivity(), OnDataPass{


    override fun onDataPass(data : Pair<String,Int>) {
        println("MAIN ACTIVITY " + data.first + " " + data.second)
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testTabLayout = findViewById<TabLayout>(R.id.tabs_main)
        val testViewPager = findViewById<ViewPager>(R.id.viewpager_main)
        val fragmentAdapter =
            MyPagerAdapter(supportFragmentManager)
        testViewPager.adapter = fragmentAdapter
        testTabLayout.setupWithViewPager(testViewPager)


        /*viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

        tabs_main.getTabAt(0)
        */



    }

    }

