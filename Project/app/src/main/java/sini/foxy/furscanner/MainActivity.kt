package sini.foxy.furscanner

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import sini.foxy.furscanner.Controller.Controller
import sini.foxy.furscanner.Exception.FurScannerException
import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter

import sini.foxy.furscanner.UI.Adapter.MyPagerAdapter
import sini.foxy.furscanner.model.RandomGenerator


//TODO : Make this breed activity?

class MainActivity : AppCompatActivity(), OnDataPass, NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle



    private var controller = Controller()
    override fun onDataPass(data : Pair<String,String>) {
        controller.onDataPass(data)
    }

    override fun onDataPass(adapter: CustomRecyclerAdapter) {
        controller.onDataPass(adapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        controller.setContext(this)
        setContentView(R.layout.activity_main)

        val testTabLayout = findViewById<TabLayout>(R.id.tabs_main)
        val testViewPager = findViewById<ViewPager>(R.id.viewpager_main)
        val fragmentAdapter =
            MyPagerAdapter(supportFragmentManager,controller.dataBaseManager)
        testViewPager.adapter = fragmentAdapter
        testTabLayout.setupWithViewPager(testViewPager)


        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        try {

        when(item.itemId){
            R.id.nav_item_breed -> controller.setMode(Modes.BREED) //TODO: Change activity to breed?
            R.id.nav_item_export ->{ onDataPass(Pair("export"," "))
            Toast.makeText(this,"Imported xml file!",Toast.LENGTH_LONG).show()}
        }
        }
        catch (error : FurScannerException){
            error.print()
        }
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    }

