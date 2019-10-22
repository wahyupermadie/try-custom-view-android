package com.example.trycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.trycustomview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main._custom_cicilan_layout.*
import kotlinx.android.synthetic.main._custom_field.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tagihan = "150000000"
        binding.cicilan = "1234567"
        binding.tunggakan = "123456789"
        binding.dateCicilan = "25-11-1997"
        binding.dateTunggakan = "Lu ga ada cicilan"
        binding.cpcPayout.onClickListener {
            Toast.makeText(this, cpc_payout.getTagihan(), Toast.LENGTH_LONG).show()
        }
    }
}
