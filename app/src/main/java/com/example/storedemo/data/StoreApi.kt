package com.example.storedemo.data

import retrofit2.http.GET

interface StoreApi {

    @GET("products")
    suspend fun getAllProducts():ProductResponse
}