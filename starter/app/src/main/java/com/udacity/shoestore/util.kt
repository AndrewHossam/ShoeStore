package com.udacity.shoestore

import android.widget.EditText

fun EditText.isValid(): Boolean {
    val isValid = text.toString().isNotBlank()
    if (isValid.not()) {
        error = context.getString(R.string.field_required)
    }

    return isValid
}