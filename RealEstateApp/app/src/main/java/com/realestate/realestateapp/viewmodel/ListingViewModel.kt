package com.realestate.realestateapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.realestate.realestateapp.model.Listing
import com.realestate.realestateapp.repository.SearchResultsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListingViewModel(application: Application) : AndroidViewModel(application) {

    private val searchResultsRepository: SearchResultsRepository = SearchResultsRepository()
    val listings: LiveData<Listing> = searchResultsRepository.result

    /**
     * Called to request the repository to get listings which are for sale.
     */
    fun requestBuyListings() = viewModelScope.launch(Dispatchers.IO) {
        searchResultsRepository.getListings("[\"Apartment / Unit / Flat\"]", "buy")
    }

    /**
     * Called to request the repository to get listings which are available to be rented
     */
    fun requestRentalListings() = viewModelScope.launch(Dispatchers.IO) {
        searchResultsRepository.getListings("[\"Apartment / Unit / Flat\"]", "rent")
    }
}