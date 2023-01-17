package com.adrianterastaginting.myfoodmarket.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarGone()
    }

    fun toolbarGone(){
        binding.includeToolbarDetail.toolbar.visibility = View.GONE
    }

    fun toolbarPayment(){
        binding.includeToolbarDetail.apply {
            toolbar.visibility = View.VISIBLE
            toolbar.title = "Payment"
            toolbar.subtitle = "You deserve better meal"
            toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_ios_24px_outlined, null)
            toolbar.setNavigationOnClickListener { onBackPressed() }
        }

    }

}