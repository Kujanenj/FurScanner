package sini.foxy.furscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CaptureManager
import kotlinx.android.synthetic.main.activity_simple_scan.*

import sini.foxy.furscanner.Controller.Controller

import java.lang.Exception
import java.util.*

class SimpleScanActivity : AppCompatActivity() {

    lateinit var captureManager: CaptureManager
    var timeout : Boolean =false



    override fun onCreate(savedInstanceState: Bundle?) {



        val controller =
            Controller(applicationContext)
        controller.setMode(Modes.BREED) //BREED MODE ENGAGE
        controller.handleCompleteButton()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_scan)

        captureManager = CaptureManager(this, barcodeView)
        captureManager.initializeFromIntent(intent, savedInstanceState)


        scan_button.setOnClickListener{

            println("CLICK")

            barcodeView.decodeContinuous(object: BarcodeCallback {
                override fun barcodeResult(result: BarcodeResult?) {
                    if(!timeout){
                        Log.d("timeout", "Time out is $timeout")

                        simple_label.text="Trying to scan"
                        timeout=true
                        result?.let {
                            println("Trying to handle results")
                            try {


                           controller.handleBarcodeResult(it)
                            println("Handeled")
                            }
                            catch (error : Exception){
                                println(error)
                                return
                            }
                        }
                        //Create a timer object so same barcode cant be scanned multiple times really fast, default delay is 5 s
                        Timer().schedule(object : TimerTask(){
                            override fun run() {
                                timeout = false
                                Log.d("Timer","Set to false")

                            }
                        },5000) //5000ms = 5 sec
                        Log.d("Timer","Started timer")
                    }}
                override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) { // TODO: whats this?
                }

        })

    }

}

    override fun onPause() {
        super.onPause()
        captureManager.onPause()
        println("ON PAUSE")
    }

    override fun onResume() {
        super.onResume()
        captureManager.onResume()
        println("ON RESUME")
    }

    override fun onDestroy() {
        super.onDestroy()
        captureManager.onDestroy()
        println("ON DESTROY!")


    }

    override fun onStop() {
        super.onStop()
        println("ON STOP")

    }
}
