package com.example.yelpsearchapplication.models

data class BusinessSearchResponse(
    val businesses: List<Business>,
    val region: Region,
    val total: Int
)