package com.adrianterastaginting.myfoodmarket.ui.main.home.recommended

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianterastaginting.myfoodmarket.databinding.FragmentHomeNewTasteBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeVerticalModel
import com.adrianterastaginting.myfoodmarket.ui.main.home.newtaste.HomeNewTasteAdapter


class HomeRecommendedFragment : Fragment() {

    private var _binding: FragmentHomeNewTasteBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<HomeVerticalModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeNewTasteBinding.inflate(inflater, container, false)

        binding.rcList.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerView()

        return binding.root
    }

    private fun showRecyclerView() {
        binding.rcList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val listDataAdapter = HomeNewTasteAdapter(list)
        binding.rcList.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : HomeNewTasteAdapter.OnItemClickCallback{
            override fun onItemClicked(data: HomeVerticalModel) {
                showSelectedData(data)
            }
        })
    }

    private fun getListData(): ArrayList<HomeVerticalModel>{
        val dataTitle = listOf("Bakwan Recommended", "Pisang Goreng Recommended","Tahu Tumbuk Recommended")
        val dataPrice = listOf("10000", "15000","23000")
        val dataSrc = listOf("https://media.suara.com/pictures/970x544/2019/12/10/88810-bakwan-sayur.jpg",
            "https://cdn.idntimes.com/content-images/community/2021/01/fromandroid-a853a450a09f5853a9cf78691a52da1f_600x400.jpg",
            "https://cdns.klimg.com/dream.co.id/resources/news/2014/10/20/6240/1200x600-resep-tahu-telur-khas-semarang-resep-tahu-telur-khas-semarang--1410207.jpg")
        val dataRating = listOf(4f, 3f, 6f)
        val listData = ArrayList<HomeVerticalModel>()
        for (i in dataTitle.indices) {
            val data = HomeVerticalModel(dataTitle[i], dataPrice[i], dataSrc[i], dataRating[i])
            listData.add(data)
        }
        return listData
    }

    private fun showSelectedData(data: HomeVerticalModel) {
        Toast.makeText(context, "Kamu memilih " + data.title, Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}