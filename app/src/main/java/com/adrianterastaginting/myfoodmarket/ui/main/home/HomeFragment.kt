package com.adrianterastaginting.myfoodmarket.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.myfoodmarket.databinding.FragmentHomeBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeModel

class HomeFragment : Fragment() {
//, HomeAdapter.OnItemClickCallback
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    //private var footList: ArrayList<HomeModel> = ArrayList()
    private val list = ArrayList<HomeModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rcList.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerView()

        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager
        )
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        return binding.root
    }

    private fun getListData(): ArrayList<HomeModel>{
        val dataTitle = listOf("Bakwan", "Pisang Goreng","Tahu Tumbuk")
        val dataSrc = listOf("https://media.suara.com/pictures/970x544/2019/12/10/88810-bakwan-sayur.jpg",
                                "https://cdn.idntimes.com/content-images/community/2021/01/fromandroid-a853a450a09f5853a9cf78691a52da1f_600x400.jpg",
                                "https://cdns.klimg.com/dream.co.id/resources/news/2014/10/20/6240/1200x600-resep-tahu-telur-khas-semarang-resep-tahu-telur-khas-semarang--1410207.jpg")
        val dataRating = listOf(4f, 3f, 6f)
        val listData = ArrayList<HomeModel>()
        for (i in dataTitle.indices) {
            val data = HomeModel(dataTitle[i], dataSrc[i], dataRating[i])
            listData.add(data)
        }
        return listData
    }

    private fun showRecyclerView() {
        binding.rcList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listDataAdapter = HomeAdapter(list)
        binding.rcList.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : HomeAdapter.OnItemClickCallback{
            override fun onItemClicked(data: HomeModel) {
                showSelectedData(data)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showSelectedData(data: HomeModel) {
        Toast.makeText(context, "Kamu memilih " + data.title, Toast.LENGTH_SHORT).show()
    }

    /*override fun onItemClicked(data: HomeModel) {
        Toast.makeText(context, "Kamu memilih ", Toast.LENGTH_SHORT).show()
    }*/
}