package com.example.trycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main._custom_field.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_testing.setOnClickListener {
            Toast.makeText(this, ctv_test.getValue() , Toast.LENGTH_LONG).show()
        }
    }
}
