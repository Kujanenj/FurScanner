package sini.foxy.furscanner.model.Listeners

import android.text.Editable
import android.text.TextWatcher

/*!
Custom textwatcher to avoid overriding the functions that are not needed.
 */
open class CustomTextWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int,
                               before: Int, count: Int) {

    }
}