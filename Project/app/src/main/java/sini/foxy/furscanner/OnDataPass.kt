package sini.foxy.furscanner

import sini.foxy.furscanner.UI.Adapter.CustomRecyclerAdapter


/*TODO: make a more sophisticated interface for dataPassing
 */
interface OnDataPass {
    fun onDataPass(data : Pair<String,String>)
    fun onDataPass(adapter : CustomRecyclerAdapter)
}