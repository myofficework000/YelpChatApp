package com.example.yelpsearchapplication.views

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yelpsearchapplication.R
import com.example.yelpsearchapplication.configs.KeyConfig
import com.example.yelpsearchapplication.databinding.ActivityMainBinding
import com.example.yelpsearchapplication.models.Result
import com.example.yelpsearchapplication.repositories.BusinessRepository
import com.example.yelpsearchapplication.viewmodels.MainViewModel
import com.example.yelpsearchapplication.viewmodels.factories.MainViewModelFactory
import com.example.yelpsearchapplication.views.adapters.RestaurantItemAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var businessRepository: BusinessRepository
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        mainViewModel.getAustinRestaurantsList()
        setupObserver()
        setupListener()
    }

    private fun setupViewModel(){
        businessRepository = BusinessRepository()
        mainViewModelFactory = MainViewModelFactory(businessRepository)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
    }

    private fun setupObserver() {
        /*mainViewModel.austinRestaurantsList.observe(this) { businessList ->
            val restaurantItemAdapter = RestaurantItemAdapter(businessList)
            mainBinding.mainRestaurantListRv.adapter = restaurantItemAdapter
            mainBinding.mainRestaurantListRv.layoutManager = LinearLayoutManager(this)
            restaurantItemAdapter.onItemClickListener = { business ->
                val intent = Intent(this, RestaurantDetailsActivity::class.java)
                intent.putExtra(KeyConfig.ID, business.id)
                startActivity(intent)
            }
        }*/

        mainViewModel.restaurantsListResult.observe(this) { result ->
            when (result) {
                is Result.Success -> {
                    val restaurantItemAdapter = RestaurantItemAdapter(result.value)
                    mainBinding.mainRestaurantListRv.adapter = restaurantItemAdapter
                    mainBinding.mainRestaurantListRv.layoutManager = LinearLayoutManager(this)
                    restaurantItemAdapter.onItemClickListener = { business ->
                        val intent = Intent(this, RestaurantDetailsActivity::class.java)
                        intent.putExtra(KeyConfig.ID, business.id)
                        startActivity(intent)
                    }
                }

                is Result.Error -> {
                    Snackbar.make(mainBinding.mainConstrainLayout, result.message.toString(), Snackbar.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }

        mainViewModel.inProgress.observe(this) { inProgress ->
            when (inProgress) {
                is Result.InProgress -> {
                    if (inProgress.value) {
                        mainBinding.progress.visibility = View.VISIBLE
                    } else
                        mainBinding.progress.visibility = View.GONE
                }
                else -> {}
            }
        }
        /*mainViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }*/
    }

    private fun setupListener(){
        mainBinding.mainSearchEt.addTextChangedListener {
            mainViewModel.searchEditTextLiveData.value = mainBinding.mainSearchEt.text.toString()
            mainViewModel.updateRestaurantsList()
        }
    }
}