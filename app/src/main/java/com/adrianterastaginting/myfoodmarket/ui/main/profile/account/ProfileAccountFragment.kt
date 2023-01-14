package com.adrianterastaginting.myfoodmarket.ui.main.profile.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianterastaginting.myfoodmarket.R
import com.adrianterastaginting.myfoodmarket.databinding.FragmentOrderBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentProfileAccountBinding
import com.adrianterastaginting.myfoodmarket.databinding.FragmentProfileBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeModel
import com.adrianterastaginting.myfoodmarket.model.dummy.ProfileMenuModel
import com.adrianterastaginting.myfoodmarket.ui.main.home.HomeAdapter
import com.adrianterastaginting.myfoodmarket.ui.main.profile.ProfileMenuAdapter


class ProfileAccountFragment : Fragment() {

    private var _binding: FragmentProfileAccountBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<ProfileMenuModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileAccountBinding.inflate(inflater, container, false)

        binding.rcList.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerView()

        return binding.root
    }

    private fun getListData(): ArrayList<ProfileMenuModel>{
        val dataTitle = listOf("Edit Profile", "Home Address", "Security", "Payments")
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