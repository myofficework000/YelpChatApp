package com.example.yelpsearchapplication.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.yelpsearchapplication.R
import com.example.yelpsearchapplication.databinding.HolderRestaurantItemAdapterBinding
import com.example.yelpsearchapplication.models.Business
import com.squareup.picasso.Picasso

class RestaurantItemAdapter(private var restaurantList: List<Business>): RecyclerView.Adapter<RestaurantItemAdapter.RestaurantItemViewHolder>() {
    inner class RestaurantItemViewHolder(var binding: HolderRestaurantItemAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(business: Business) {
            binding.business = business
            Picasso.get()
                .load(business.image_url)
                .fit()
                .into(binding.holderRestaurantImageIv)
            binding.holderRestaurantRatingTv.text = "${binding.root.context.getText(R.string.rating)} ${business.rating}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<HolderRestaurantItemAdapterBinding>(inflater, R.layout.holder_restaurant_item_adapter, parent, false)
        return RestaurantItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantItemViewHolder, position: Int) {
        holder.bind(restaurantList[position])

        if (this::onItemClickListener.isInitialized) {
            holder.binding.root.setOnClickListener {
                onItemClickListener(restaurantList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    lateinit var onItemClickListener:(business: Business) -> Unit
}