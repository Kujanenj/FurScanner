package sini.foxy.furscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult




//TODO : replace all test stuff with actual implementations
//DESKTOP-06IBLMI
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        var testParser = Parser()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testButton = findViewById<Button>(R.id.fragmentButton)
        testButton.setOnClickListener{
            println("**Click**")

            println(testParser.parse("0005302004007210"))

            println(getString(R.string.breeding_animal_single))
     /*   val testTransaction = supportFragmentManager.beginTransaction();
            testTransaction.add(R.id.placeHolderLayout,testFragment())
            testTransaction.commit()

      */
        }

    }
}
