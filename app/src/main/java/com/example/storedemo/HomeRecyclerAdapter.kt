package com.example.storedemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storedemo.databinding.ItemProductBinding
import com.example.storedemo.ext.downloadFromUrl

class HomeRecyclerAdapter ():RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    private var productList : List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(ItemProductBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int =productList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(productList[position])
    }


    class HomeViewHolder(val binding: ItemProductBinding ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            with(product) {
                binding.apply {
                    productTitle.text = title
                    rate.text = "${rating?.rate} (${rating?.count})"
                    productPrice.text = "${getPrettyPrice()} TL"
                    productImage.downloadFromUrl(image)
                }
            }
        }
    }

    fun submitList(list: List<Product>) {
        productList =list
        notifyDataSetChanged()
    }
}