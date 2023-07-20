package com.example.myapplication.api_interface

import com.example.myapplication.api_response.api_response
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    // Define the endpoint URL
    @GET("entries")
    fun getEntries(): Call<api_response>

 }
