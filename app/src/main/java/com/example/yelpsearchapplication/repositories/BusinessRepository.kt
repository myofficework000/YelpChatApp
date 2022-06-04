package com.example.yelpsearchapplication.repositories

import com.example.yelpsearchapplication.networks.RetrofitClient
import com.example.yelpsearchapplication.networks.RetrofitService

class BusinessRepository {
    private val retrofitService: RetrofitService = RetrofitClient.getRetrofitService()

    suspend fun getAustinRestaurantsList() = retrofitService.getAustinRestaurantsList()

    suspend fun getRestaurantDetails(id: String) = retrofitService.getRestaurantDetail(id)
}