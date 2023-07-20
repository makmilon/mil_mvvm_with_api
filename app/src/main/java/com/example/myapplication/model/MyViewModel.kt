package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api_interface.ApiEndpoint
import com.example.myapplication.api_interface.RetrofitClient
import com.example.myapplication.api_response.Entry
import com.example.myapplication.api_response.api_response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel() {
    private val apiEndpoint = RetrofitClient.getClient().create(ApiEndpoint::class.java)
    private val _entries = MutableLiveData<List<Entry>>()
    val entries: LiveData<List<Entry>> get() = _entries

    // Call this function to fetch data from the API
    fun fetchEntries() {
        apiEndpoint.getEntries().enqueue(object : Callback<api_response> {
            override fun onResponse(call: Call<api_response>, response: Response<api_response>) {
                if (response.isSuccessful) {
                    _entries.value = response.body()?.entries
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<api_response>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
