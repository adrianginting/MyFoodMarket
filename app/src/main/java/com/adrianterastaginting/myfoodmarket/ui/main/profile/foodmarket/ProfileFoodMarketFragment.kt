package com.adrianterastaginting.myfoodmarket.ui.main.profile.foodmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentOrderBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentProfileBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentProfileFoodMarketBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.ProfileMenuModel
import com.adrianterastaginting.myfoodmarket.ui.main.profile.ProfileMenuAdapter

class ProfileFoodMarketFragment : Fragment() {

    private var _binding: FragmentProfileFoodMarketBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<ProfileMenuModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileFoodMarketBinding.inflate(inflater, container, false)

        list.addAll(getListData())
        showRecyclerView()

        return binding.root
    }
    private fun getListData(): ArrayList<ProfileMenuModel>{
        val dataTitle = listOf("Rate App", "Help Center", "Privacy & Policy", "Terms & Conditions")
        val listData = ArrayList<ProfileMenuModel>()
        for (i in dataTitle.indices) {
            val data = ProfileMenuModel(dataTitle[i])
            listData.add(data)
        }
        return listData
    }

    private fun showRecyclerView() {
        binding.rcList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val listDataAdapter = ProfileMenuAdapter(list)
        binding.rcList.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : ProfileMenuAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ProfileMenuModel) {
                showSelectedData(data)
            }
        })
    }

    private fun showSelectedData(data: ProfileMenuModel) {
        Toast.makeText(context, "Kamu memilih " + data.title, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}