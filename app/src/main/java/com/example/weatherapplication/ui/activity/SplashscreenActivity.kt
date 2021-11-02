package com.example.weatherapplication.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        goToMainActivity()
    }
    private fun goToMainActivity(){
        CoroutineScope(Dispatchers.Main).launch {
            delay(SCREEN_DELAY)
            startActivity(Intent(this@SplashscreenActivity, HomeActivity::class.java))
            finish()
        }
    }

    companion object {
        private const val SCREEN_DELAY = 5000L
    }
}