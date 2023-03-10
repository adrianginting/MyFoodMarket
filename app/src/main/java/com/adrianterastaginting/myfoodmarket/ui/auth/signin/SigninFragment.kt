package com.adrianterastaginting.myfoodmarket.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adrianterastaginting.myfoodmarket.MainActivity
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentSigninBinding
import com.adrianterastaginting.myfoodmarket.ui.auth.AuthActivity

class SigninFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSigninBinding.inflate(inflater, container, false)

        binding.btnSignup.setOnClickListener(this)
        binding.btnSignin.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSignup -> {
                val signup = Intent(activity, AuthActivity::class.java)
                signup.putExtra("page_request", 2)
                startActivity(signup)
            }
            R.id.btnSignin -> {
                val signin = Intent(activity, MainActivity::class.java)
                startActivity(signin)
                activity?.finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}