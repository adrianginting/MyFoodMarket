package com.adrianterastaginting.myfoodmarket.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianterastaginting.myfoodmarket.databinding.ActivityDetailBinding
import com.adrianterastaginting.myfoodmarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}