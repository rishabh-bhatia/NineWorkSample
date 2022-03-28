package com.realestate.realestateapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApiUtilities {

    private const val BASE_URL = "https://sampleapi.com"

    /**
     * Called to setup a retrofit instance which can be used to perform further network operations
     *
     * @return Retrofit object/instance to create requests
     */
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}