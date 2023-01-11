package com.adrianterastaginting.myfoodmarket.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.adrianterastaginting.myfoodmarket.databinding.ActivitySplashScreenBinding
import com.adrianterastaginting.myfoodmarket.ui.auth.AuthActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
        }, 3000)

    }
}