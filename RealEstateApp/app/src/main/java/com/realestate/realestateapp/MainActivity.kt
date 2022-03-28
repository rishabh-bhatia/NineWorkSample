package com.realestate.realestateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.realestate.realestateapp.rvadapter.ListingsRVAdapter
import com.realestate.realestateapp.viewmodel.ListingViewModel
import com.realestate.realestateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listingViewModel: ListingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listRecyclerView.layoutManager = LinearLayoutManager(this)
        var listingsRVAdapter: ListingsRVAdapter
        listingViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ListingViewModel::class.java)
        listingViewModel.listings.observe(this) { listing ->
            listingsRVAdapter = ListingsRVAdapter(listing)
            binding.listRecyclerView.adapter = listingsRVAdapter
        }
        binding.buyButton.setOnClickListener {
            onBuyButtonPressed()
        }
        binding.rentButton.setOnClickListener {
            onRentButtonPressed()
        }
    }

    /**
     * Requests View model to get listings available for sale
     */
    private fun onBuyButtonPressed() {
        listingViewModel.requestBuyListings()
    }

    /**
     * Requests View model to get listings available to be rented
     */
    private fun onRentButtonPressed() {
        listingViewModel.requestRentalListings()
    }
}