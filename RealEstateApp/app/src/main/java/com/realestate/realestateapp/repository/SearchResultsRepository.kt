package com.realestate.realestateapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.realestate.realestateapp.api.RetrofitAPIInterface
import com.realestate.realestateapp.api.RetrofitApiUtilities
import com.realestate.realestateapp.exception.UnexpectedDataException
import com.realestate.realestateapp.model.Listing
import com.realestate.realestateapp.model.RequestModel

class SearchResultsRepository {

    private val retrofitAPIInterface =
        RetrofitApiUtilities.getRetrofitInstance().create(RetrofitAPIInterface::class.java)
    private val resultLiveData = MutableLiveData<Listing>()
    val result: LiveData<Listing>
        get() = resultLiveData

    /**
     * Create a post request to get listings and update live data if the response is not null
     *
     * @param dwelling_types Dwelling Types of properties being searched
     * @param search_mode Status of the properties being searched. For example:- Buy or Rent
     * @throws UnexpectedDataException Throws exception when the response is not what we expected
     */
    suspend fun getListings(dwelling_types: String, search_mode: String) {
        val requestModel = RequestModel(dwelling_types, search_mode)
        val response = retrofitAPIInterface.getListings(requestModel)
        if (response.body() != null) {
            resultLiveData.postValue(response.body())
        } else {
            throw UnexpectedDataException("We did not expect this to happen. Handle it!")
        }
    }
}