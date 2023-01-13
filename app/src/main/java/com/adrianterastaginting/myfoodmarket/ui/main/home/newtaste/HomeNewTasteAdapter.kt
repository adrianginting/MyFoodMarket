package com.adrianterastaginting.myfoodmarket.ui.main.home.newtaste

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.myfoodmarket.databinding.ItemHomeHorizontalBinding
import com.adrianterastaginting.myfoodmarket.databinding.ItemHomeVerticalBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeModel
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeVerticalModel
import com.adrianterastaginting.myfoodmarket.utils.Helpers.formatPrice
import com.bumptech.glide.Glide

class HomeNewTasteAdapter(private val listData: ArrayList<HomeVerticalModel>) : RecyclerView.Adapter<HomeNewTasteAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemHomeVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, price, src, rating) = listData[position]
        Glide.with(holder.itemView.context)
            .load(src)
            .into(holder.binding.ivPoster)
        holder.binding.tvTitle.text = title
        holder.binding.tvPrice.formatPrice(price)
        holder.binding.rbFood.rating = rating
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(var binding: ItemHomeVerticalBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: HomeVerticalModel)
    }
}