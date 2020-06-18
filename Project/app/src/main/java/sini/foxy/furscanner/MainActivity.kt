package sini.foxy.furscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


typealias IdPair = Pair<String,String>
enum class Modes( ) {
    BREED,
    NO_MODE
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
