package com.example.weatherapplication.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.weatherapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add = findViewById(R.id.sumButton) as Button?
        val answer = findViewById(R.id.Result) as TextView
        val num1 = findViewById(R.id.firstNumber) as EditText
        val num2 = findViewById(R.id.secondNumber) as EditText

        val sci = findViewById(R.id.sciButton) as Button?

        add?.setOnClickListener {
            answer.setText("Answer: "+ (num1.text.toString().toInt()+num2.text.toString().toInt()).toString())
        }
        sci?.setOnClickListener {
            val i = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }
    }
}