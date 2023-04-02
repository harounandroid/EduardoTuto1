package com.wstechnologies.eduardocicd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edittext = findViewById<EditText>(R.id.edit_name)
        val button = findViewById<Button>(R.id.button)
        val txt_name = findViewById<TextView>(R.id.txt_name)
        button.setOnClickListener {
            txt_name.text="hello "+edittext.text.toString()+"\nHayet1"
        }

    }
}