package com.example.yelpsearchapplication.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.yelpsearchapplication.R
import com.example.yelpsearchapplication.configs.KeyConfig
import com.example.yelpsearchapplication.databinding.ActivityRestaurantDetailsBinding
import com.example.yelpsearchapplication.repositories.BusinessRepository
import com.example.yelpsearchapplication.viewmodels.RestaurantDetailsViewModel
import com.example.yelpsearchapplication.viewmodels.factories.RestaurantDetailsViewModelFactory
import com.squareup.picasso.Picasso

class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var activityRestaurantDetailsBinding: ActivityRestaurantDetailsBinding
    private lateinit var viewModel: RestaurantDetailsViewModel
    private lateinit var businessRepository: BusinessRepository
    private lateinit var viewModelViewModelFactory: RestaurantDetailsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRestaurantDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_details)
        setupViewModel()
        val id = intent.getStringExtra(KeyConfig.ID)
        viewModel.getRestaurantDetails(id?: "")
        setupObserver()
        activityRestaurantDetailsBinding.viewModel = viewModel
    }

    private fun setupViewModel() {
        businessRepository = BusinessRepository()
        viewModelViewModelFactory = RestaurantDetailsViewModelFactory(businessRepository)
        viewModel = ViewModelProvider(this, viewModelViewModelFactory)[RestaurantDetailsViewModel::class.java]
        activityRestaurantDetailsBinding.lifecycleOwner = this
    }

    @SuppressLint("SetTextI18n")
    private fun setupObserver() {
        viewModel.restaurantDetailsLiveData.observe(this) { business ->
            Picasso.get()
                .load(business.image_url)
                .fit()
                .into(activityRestaurantDetailsBinding.restaurantDetailsImageIv)
/*
            activityRestaurantDetailsBinding.restaurantDetailsNameTv.text = business.name
            activityRestaurantDetailsBinding.restaurantDetailsRatingTv.text = "${getString(R.string.rating)} ${business.rating}"
            var stringCategories = "Categories: "
            for (category in business.categories) {
                stringCategories += " ${category.title}"
            }
            activityRestaurantDetailsBinding.restaurantDetailsCategoriesTv.text = stringCategories
            activityRestaurantDetailsBinding.restaurantDetailsPriceTv.text = business.price*/
        }

        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}