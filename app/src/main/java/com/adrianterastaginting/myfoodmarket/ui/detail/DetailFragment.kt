package com.adrianterastaginting.myfoodmarket.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.adrianterastaginting.myfoodmarket.MainActivity
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        //(activity as DetailActivity).toolbarGone()
        //DetailActivity().toolbarGone()


        binding.btnOrderNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment, null)
            //(activity as DetailActivity).toolbarPayment()
        }

        binding.btnBack.setOnClickListener{
            val intentBack = Intent(context, MainActivity::class.java)
            startActivity(intentBack)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}