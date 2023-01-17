package com.adrianterastaginting.myfoodmarket.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentPaymentBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentPaymentSuccessBinding

class PaymentSuccessFragment : Fragment() {

    private var _binding: FragmentPaymentSuccessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPaymentSuccessBinding.inflate(inflater, container, false)

        //(activity as DetailActivity).toolbarGone()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}