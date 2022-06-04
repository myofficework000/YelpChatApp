package com.example.yelpsearchapplication.networks

import com.example.yelpsearchapplication.configs.KeyConfig
import com.example.yelpsearchapplication.configs.UrlConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
        fun getRetrofitService(): RetrofitService {
            val interceptor = Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.addHeader(KeyConfig.AUTHORIZATION, KeyConfig.YELP_API_KEY)
                return@Interceptor chain.proceed(builder.build())
            }

            val logInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(logInterceptor)
                .build()

            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(UrlConfig.BASE_URL)
                .build()
                .create(RetrofitService::class.java)
        }
}