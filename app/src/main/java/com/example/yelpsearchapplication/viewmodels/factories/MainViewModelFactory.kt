package com.example.yelpsearchapplication.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yelpsearchapplication.repositories.BusinessRepository

class MainViewModelFactory(private var businessRepository: BusinessRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(BusinessRepository::class.java).newInstance(businessRepository)
    }
}