package com.example.storedemo

data class Product(
    val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
){
    fun getPrettyPrice(): String {
        var isInteger = false
        price?.let {
            if(it % 1.0 == 0.0)
                isInteger = true
        }
        return if (isInteger) {
            price?.toInt().toString()
        } else price.toString()
    }
}

data class Rating(
    val rate: Double,
    val count: Int
)


