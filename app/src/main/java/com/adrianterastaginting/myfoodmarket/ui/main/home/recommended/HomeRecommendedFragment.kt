package com.adrianterastaginting.myfoodmarket.ui.main.home.recommended

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrianterastaginting.myfoodmarket.databinding.FragmentHomeNewTasteBinding


class HomeRecommendedFragment : Fragment() {

    private var _binding: FragmentHomeNewTasteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeNewTasteBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}