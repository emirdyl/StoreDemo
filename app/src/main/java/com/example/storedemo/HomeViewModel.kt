package com.example.storedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storedemo.data.RetrofitInstance
import com.example.storedemo.ext.toLiveData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){

    private val _homeProductLiveData = MutableLiveData<List<Product>>()

    val homeProductLiveData = _homeProductLiveData.toLiveData()

    init {
        getAllProducts()
    }
    private fun getAllProducts() {

        viewModelScope.launch {
                val ProductDto = RetrofitInstance.api.getAllProducts()
                val productList = ProductDto.map {productDto ->
                    Product(
                        id = productDto.id,
                        title = productDto.title,
                        price = productDto.price,
                        description = productDto.description,
                        category=productDto.category,
                        image = productDto.image,
                        rating = Rating(
                            rate = productDto.rating.rate,
                            count =productDto.rating.count
                        )
                    )
                }
            _homeProductLiveData.value =(productList)

        }
    }

}