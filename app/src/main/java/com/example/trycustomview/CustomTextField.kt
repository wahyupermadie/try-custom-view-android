package com.example.trycustomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.LinearLayoutCompat
import kotlinx.android.synthetic.main._custom_field.view.*

class CustomTextField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {
    init {
        setupProperty(context, attrs)
    }
    var isRequired : Boolean  = false
    var minLength : Int = 0
    var validationType : Int = 0
    private fun setupProperty(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout._custom_field, this, true)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomField,
            0, 0)
        settingProperty(context, typedArray)
    }

    private fun settingProperty(context: Context, typedArray: TypedArray) {
        val value = typedArray.getString(R.styleable.CustomField_value)
        val label = typedArray.getString(R.styleable.CustomField_label)
        val information = typedArray.getString(R.styleable.CustomField_information)
        val color = typedArray.getColor(R.styleable.CustomField_textColor, resources.getColor(R.color.colorPrimary))
        validationType = typedArray.getInt(R.styleable.CustomField_validationType, 0)
        minLength = typedArray.getInt(R.styleable.CustomField_minLength, 0)
        isRequired = typedArray.getBoolean(R.styleable.CustomField_isRequired, false)

        tv_label.text = label
        tv_information.text = information
        setValue(value)
        setColor(color)

    }

    private fun setColor(color: Int) {
        acet_input.setTextColor(color)
    }

    fun setValue(data: String?){
        acet_input.setText(data)
    }

    fun getValue(): String = acet_input.text?.toString()?: ""

    fun getField() : AppCompatEditText = acet_input
}