package com.example.weatherapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.fragment.FirstFragment

class HomeActivity : AppCompatActivity() {
    private val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val transaction = manager.beginTransaction()
        val fragment = FirstFragment()
        transaction.replace(R.id.frame_holder, fragment)
        transaction.commit()
    }





}