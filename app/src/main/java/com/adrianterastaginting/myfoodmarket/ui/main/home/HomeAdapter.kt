package com.adrianterastaginting.myfoodmarket.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.myfoodmarket.databinding.ItemHomeHorizontalBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeModel
import com.bumptech.glide.Glide

class HomeAdapter(private val listData: ArrayList<HomeModel>) : RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemHomeHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, src, rating) = listData[position]
        Glide.with(holder.itemView.context)
            .load(src)
            .into(holder.binding.ivPoster)
        holder.binding.tvTitle.text = title
        holder.binding.rbFood.rating = rating
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(var binding: ItemHomeHorizontalBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: HomeModel)
    }
}