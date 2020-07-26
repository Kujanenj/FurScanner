package sini.foxy.furscanner.UI.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.google.zxing.ResultPoint
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import kotlinx.android.synthetic.main.fragment_scan.*
import sini.foxy.furscanner.R

/**
 * Contains the Camera Scanner
 */
class ScanFrag : AbstractPasserFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_scan, container, false)
    }
    fun scanFromFragment() {
        val intent = IntentIntegrator.forSupportFragment(this)
        intent.setBeepEnabled(true)
        barcodeViewFrag.initializeFromIntent(intent.createScanIntent())
        barcodeViewFrag.decodeContinuous(object: BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                result?.let {
                    println("Trying to handle results")
                    try {
                            passData("bar",it.toString())
                    }
                    catch (error : Exception){
                        println(error)
                        return
                    }
                }
            }
            override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) { // TODO: whats this?
            }
        })
    }
    override fun onResume() {
        super.onResume()
        scanFromFragment()
        barcodeViewFrag.resume()
    }


}
