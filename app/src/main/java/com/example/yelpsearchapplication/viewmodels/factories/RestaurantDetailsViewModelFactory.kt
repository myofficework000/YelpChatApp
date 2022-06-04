package com.example.yelpsearchapplication.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yelpsearchapplication.repositories.BusinessRepository

class RestaurantDetailsViewModelFactory(private var businessRepository: BusinessRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(businessRepository::class.java).newInstance(businessRepository)
    }
}