package com.example.yelpsearchapplication.networks

import com.example.yelpsearchapplication.configs.UrlConfig
import com.example.yelpsearchapplication.models.Business
import com.example.yelpsearchapplication.models.BusinessSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("${UrlConfig.BUSINESS_SEARCH_ENDPOINT}${UrlConfig.QUERY_AUSTIN_RESTAURANTS}")
    suspend fun getAustinRestaurantsList(): Response<BusinessSearchResponse>

    @GET("${UrlConfig.BUSINESS_ENDPOINT}/{id}")
    suspend fun getRestaurantDetail(@Path("id") id: String): Response<Business>
}