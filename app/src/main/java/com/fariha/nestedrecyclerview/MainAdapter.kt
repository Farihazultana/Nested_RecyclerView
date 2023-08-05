package com.fariha.nestedrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fariha.nestedrecyclerview.databinding.BannerItemBinding
import com.fariha.nestedrecyclerview.databinding.EachItemBinding

class MainAdapter(private val dataItemList: List<DataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class BannerItemViewHolder(private val binding: BannerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindBannerView(banner: Banner){
            binding.bannerIV.setImageResource(banner.image)
        }
    }

    inner class RecyclerItemViewHolder(private val binding: EachItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return  dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}