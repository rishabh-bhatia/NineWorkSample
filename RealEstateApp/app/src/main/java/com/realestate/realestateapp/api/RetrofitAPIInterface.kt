package com.realestate.realestateapp.api

import com.realestate.realestateapp.model.Listing
import com.realestate.realestateapp.model.RequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPIInterface {
    /**
     * Called to make a post request using Retrofit
     *
     * @param requestModel Data object that will be sent as the body of post request
     * @return A response that contains a Listing object
     */
    @POST("/v1/search")
    suspend fun getListings(@Body requestModel: RequestModel): Response<Listing>
}