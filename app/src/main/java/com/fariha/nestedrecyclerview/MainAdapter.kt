package com.fariha.nestedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
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

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }
        fun bindClothingRecyclerView(recyclerItemList: List<RecyclerItem>){
            binding.childRecyclerView.setHasFixedSize(true)
        }
        fun bindBestSellerRecyclerView(recyclerItemList: List<RecyclerItem>){

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(dataItemList[position].viewType){
            DataItemType.BANNER ->
                R.layout.banner_item
            else ->
                R.layout.each_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType){
            R.layout.banner_item -> {
                val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerItemViewHolder(binding)
            }
            else ->{
                val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return  dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BannerItemViewHolder -> {
                dataItemList[position].banner?.let { holder.bindBannerView(it) }
            }
            else ->{
                when(dataItemList[position].viewType){
                    DataItemType.BEST_SELLER -> {
                        dataItemList[position].recyclerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindBestSellerRecyclerView(it)
                        }
                    }
                    else ->{
                    dataItemList[position].recyclerItemList?.let {
                        (holder as RecyclerItemViewHolder).bindClothingRecyclerView(it)
                    }
                }
                }
            }
        }
    }


}