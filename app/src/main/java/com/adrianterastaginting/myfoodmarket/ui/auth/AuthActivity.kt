package com.adrianterastaginting.myfoodmarket.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianterastaginting.myfoodmarket.databinding.ActivityAuthBinding
import com.adrianterastaginting.myfoodmarket.databinding.ActivityMainBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}