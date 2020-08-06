package sini.foxy.furscanner.UI.Fragment


import android.app.AlertDialog
import android.content.DialogInterface
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.google.zxing.ResultPoint
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import kotlinx.android.synthetic.main.fragment_scan.*
import org.w3c.dom.Text
import sini.foxy.furscanner.Modes
import sini.foxy.furscanner.R
import sini.foxy.furscanner.model.DataBaseManager
import sini.foxy.furscanner.model.Listeners.AbstractObservable
import sini.foxy.furscanner.model.Listeners.InterfaceObserver
import java.util.*

/**
 * Contains the Camera Scanner
 */
class ScanFrag(override var observable: AbstractObservable) : AbstractPasserFragment() ,InterfaceObserver{
    val  toneGen = ToneGenerator(AudioManager.STREAM_MUSIC,100)
    var  scanTimeout = false
    var dataBase = observable as DataBaseManager
    lateinit var farmLabel :   TextView
    lateinit var    IDlabel :  TextView
    lateinit var houselabel :  TextView
    lateinit var  cagelabel :  TextView
    override fun onUpdate() {
        farmLabel.setText((dataBase.getContainer(Modes.BREED).last().birthFarm))
        IDlabel.setText((dataBase.getContainer(Modes.BREED).last().sampoId))
        houselabel.setText(dataBase.getContainer(Modes.BREED).last().getLocation().house.toString())
        cagelabel.setText(dataBase.getContainer(Modes.BREED).last().getLocation().cage.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase.addObserver(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_scan, container, false)
        val button = view.findViewById<Button>(R.id.testButton)
        button.setOnClickListener{
            passData("test","sss")

        }
        farmLabel = view.findViewById(R.id.item_farm_and_id_FarmLabel)
        IDlabel = view.findViewById(R.id.item_farm_and_id_IDLabel)
        houselabel = view.findViewById(R.id.item_farm_and_id_HouseLabel)
        cagelabel= view.findViewById(R.id.item_farm_and_id_CageLabel)

        return view
    }
    fun scanFromFragment() {
        val intent = IntentIntegrator.forSupportFragment(this)

        barcodeViewFrag.initializeFromIntent(intent.createScanIntent())
        barcodeViewFrag.decodeContinuous(object: BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                if(!scanTimeout) {
                    scanTimeout=true
                    result?.let {
                        try {
                            Timer().schedule(object : TimerTask(){
                                override fun run() {
                                   scanTimeout  = false
                                }
                            },5000) //5000ms = 5 sec

                            passData("bar", it.toString())

                            toneGen.startTone(ToneGenerator.TONE_CDMA_PIP, 150)

                        } catch (error: Exception) {
                            println(error)
                            scanTimeout=false

                        }
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
