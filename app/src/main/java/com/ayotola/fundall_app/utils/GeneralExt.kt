package com.ayotola.fundall_app.utils

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONException
import org.json.JSONObject
import java.util.*

fun String?.parseError(): GeneralError {
    val error = try {
        if (this !== null) {
            val error = JSONObject(this)
            error.getString("detail")
        } else {
            "Something went wrong"
        }
    } catch (e: JSONException) {
        "Something went wrong"
    }
    return GeneralError(error)
}

fun Int?.formatToThousand(): String = "%,d".format(this)

fun Fragment.hideSoftKeyboard() {
    val view = requireActivity().currentFocus
    view?.let {
        val imm = requireActivity().getSystemService<InputMethodManager>()
        imm?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.hideSoftKeyboard() {
    val view = this.currentFocus
    view?.let {
        val imm = this.getSystemService<InputMethodManager>()
        imm?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}


fun TextInputEditText.text(): String {
    return this.editableText.toString()
}

//fun ImageView.loadImage(url: String) {
//    if (url.isNotEmpty()) {
//        load(url)
//    }
//}

fun EditText.text() = this.text.toString()

fun EditText.isEmpty() = this.text.toString().isEmpty()

fun Activity.showMessage(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showMessage(msg: String? = "") {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

val numberFormat = Regex("^[+]?[(]?0[7-9][0-1][)]?[0-9]{3}[0-9]{4,7}$")

fun Long.stripOutTime(): Long {
    val current = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
        timeInMillis = this@stripOutTime
    }

    val utcTIme = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
        clear()

        set(
            current.get(Calendar.YEAR),
            current.get(Calendar.MONTH),
            current.get(Calendar.DAY_OF_MONTH)
        )
    }
    return utcTIme.timeInMillis
}