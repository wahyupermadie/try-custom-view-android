package com.example.trycustomview.ext

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.example.trycustomview.CustomTextField


object BindingExt {
    @InverseBindingAdapter(attribute = "customTextFieldValue")
    @JvmStatic
    fun getCustomTextFieldValue(view: CustomTextField): String {
        return view.getValue()
    }

    @BindingAdapter("app:customTextFieldValue")
    @JvmStatic
    fun setCustomTextFieldValue(view: CustomTextField, value: String) {
        if (value != view.getValue()) view.setValue(value)
    }

    @BindingAdapter("app:customTextFieldValueAttrChanged")
    @JvmStatic
    fun setListenerCustomTextField(customField: CustomTextField, listener: InverseBindingListener) {
        customField.getField().addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) = listener.onChange()
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }
}