package com.example.yelpsearchapplication.models

data class Business(
    val alias: String,
    val categories: List<Category>,
    val coordinates: Coordinates,
    val distance: Double,
    val id: String,
    val image_url: String,
    val is_closed: Boolean,
    val location: Location,
    val name: String,
    val phone: String,
    val price: String,
    val rating: String,
    val review_count: Int,
    val transactions: List<String>,
    val url: String
)