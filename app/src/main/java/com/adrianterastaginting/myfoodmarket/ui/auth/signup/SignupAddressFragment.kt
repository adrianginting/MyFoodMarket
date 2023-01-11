package com.adrianterastaginting.myfoodmarket.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentSigninBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentSignupAddressBinding
import com.adrianterastaginting.myfoodmarket.ui.auth.AuthActivity

class SignupAddressFragment : Fragment() {

    private var _binding: FragmentSignupAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupAddressBinding.inflate(inflater, container, false)

        binding.btnSignupNow.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_signup_seccess, null)

            (activity as AuthActivity).toolbarSignupSuccess()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}