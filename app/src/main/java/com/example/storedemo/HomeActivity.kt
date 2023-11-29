package com.example.storedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storedemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var adapter: HomeRecyclerAdapter? = null

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRecyclerView()
        observeViewModel()
    }

    private fun setRecyclerView() {
        adapter = HomeRecyclerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun observeViewModel() {
        viewModel.homeProductLiveData.observe(this) { productList ->
            if (productList.isNullOrEmpty()) {
                // show empty view
            } else {
                adapter?.submitList(productList)
            }

        }

    }
}