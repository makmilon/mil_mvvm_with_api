package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.EntryAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var entryAdapter: EntryAdapter
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Set the ViewModel variable in the layout to the ViewModel instance
        binding.viewModel = viewModel

        // Initialize the RecyclerView and Adapter
        entryAdapter = EntryAdapter()
        binding.recview.layoutManager = LinearLayoutManager(this)
        binding.recview.adapter = entryAdapter

        // Call the function in ViewModel to fetch data from the API
        viewModel.fetchEntries()

        // Observe the LiveData to update the RecyclerView when data is available
        viewModel.entries.observe(this, { entries ->
            entryAdapter.setData(entries)
        })
    }
}
