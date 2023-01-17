package com.adrianterastaginting.myfoodmarket.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentDetailBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)

        //(activity as DetailActivity).toolbarPayment()

        binding.btnCheckout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment_success)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}