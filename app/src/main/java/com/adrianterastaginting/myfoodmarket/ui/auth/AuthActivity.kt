package com.adrianterastaginting.myfoodmarket.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.ActivityAuthBinding
import com.adrianterastaginting.myfoodmarket.databinding.ActivityMainBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val pageRequest = intent.getIntExtra("page_request",0)
        if (pageRequest == 2){
            toolbarSignup()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()
            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_signup, null, navOptions)
        }


    }

    fun toolbarSignup(){
        binding.toolbar.title = "Sign Up"
        binding.toolbar.subtitle = "Register and meat"
        binding.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_ios_24px_outlined, null)
        binding.toolbar.setNavigationOnClickListener { onBackPressed()}
    }
    fun toolbarSignupAddress(){
        binding.toolbar.title = "Address"
        binding.toolbar.subtitle = "Make sure it's valid"
        binding.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_ios_24px_outlined, null)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }
    fun toolbarSignupSuccess(){
        binding.toolbar.visibility = View.GONE
    }
}