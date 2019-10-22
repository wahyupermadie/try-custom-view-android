package com.example.trycustomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main._custom_cicilan_layout.view.*
import java.text.NumberFormat
import java.util.*
import java.text.ParseException
import java.text.SimpleDateFormat


class CustomPayoutComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr){
    init {
        setupProperty(context, attrs)
    }

    private var localeID = Locale("in", "ID")
    private var formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
    private val regexDate = Regex("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d\$")

    private fun setupProperty(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout._custom_cicilan_layout, this, true)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomPayoutComponent,
            0, 0)
        settingProperty(context, typedArray)
    }

    private fun settingProperty(context: Context, typedArray: TypedArray) {
        val tagihanLabel = typedArray.getString(R.styleable.CustomPayoutComponent_tagihanLabel)
        val tagihan = typedArray.getString(R.styleable.CustomPayoutComponent_tagihan)
        val cicilanLabel = typedArray.getString(R.styleable.CustomPayoutComponent_cicilanLabel)
        val cicilan = typedArray.getString(R.styleable.CustomPayoutComponent_cicilan)
        val dateCicilan = typedArray.getString(R.styleable.CustomPayoutComponent_dateCicilan)
        val tunggakanLabel = typedArray.getString(R.styleable.CustomPayoutComponent_tunggakanLabel)
        val tunggakan = typedArray.getString(R.styleable.CustomPayoutComponent_tunggakan)
        val dateTunggakan = typedArray.getString(R.styleable.CustomPayoutComponent_dateTunggakan)

        actv_label_tagihan.text = tagihanLabel
        actv_label_cicilan.text = cicilanLabel
        actv_date_cicilan.text = dateCicilan
        actv_label_tunggakan.text = tunggakanLabel
    }

    fun setTagihan(tagihan: String) {
        actv_tagihan.text = formatRupiah.format(tagihan.toDouble())
    }

    fun getTagihan() : String {
        return actv_tagihan.text.toString()
    }

    fun setCicilanDate(cicilanDate : String) {
        actv_date_cicilan.text =
            if (regexDate.matches(cicilanDate)) formatDate(cicilanDate, "dd-MM-yyyy", "dd MMM yyyy") else cicilanDate
    }

    fun setCicilan(cicilan: String) {
        actv_cicilan.text = formatRupiah.format(cicilan.toDouble())
    }

    fun getCicilan() : String {
        return actv_cicilan.text.toString()
    }

    fun setTunggakan(tunggakan : String?) {
        actv_tunggakan.text = formatRupiah.format(tunggakan?.toDouble() ?: "0")
    }

    fun setTunggakanDate(tunggakanDate : String) {
        actv_date_tunggakan.text =
            if (regexDate.matches(tunggakanDate)) formatDate(tunggakanDate, "dd-MM-yyyy", "dd MMM yyyy") else tunggakanDate
    }

    fun getTunggakan() : String {
        return actv_tunggakan.text.toString()
    }

    fun onClickListener(func: () -> Unit) {
        acb_btn_action.setOnClickListener {
            func()
        }
    }

    private fun formatDate(date: String?, formatFrom: String, formatTo: String): String {
        return if (date.isNullOrEmpty()) {
            ""
        } else {
            try {
                val dateFormatFrom = SimpleDateFormat(formatFrom, localeID)
                val dateFrom = dateFormatFrom.parse(date)
                val dateFormat = SimpleDateFormat(formatTo, localeID)
                val hireDate = dateFormat.format(dateFrom)
                hireDate
            } catch (e: ParseException) {
                date.toString()
            }
        }
    }
}