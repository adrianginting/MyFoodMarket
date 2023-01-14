package com.adrianterastaginting.myfoodmarket.ui.main.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.myfoodmarket.databinding.ItemHomeHorizontalBinding
import com.adrianterastaginting.myfoodmarket.databinding.ItemMenuProfileBinding
import com.adrianterastaginting.myfoodmarket.model.dummy.HomeModel
import com.adrianterastaginting.myfoodmarket.model.dummy.ProfileMenuModel
import com.bumptech.glide.Glide

class ProfileMenuAdapter(private val listData: ArrayList<ProfileMenuModel>) : RecyclerView.Adapter<ProfileMenuAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemMenuProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title) = listData[position]

        holder.binding.tvTitle.text = title
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(var binding: ItemMenuProfileBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: ProfileMenuModel)
    }
}