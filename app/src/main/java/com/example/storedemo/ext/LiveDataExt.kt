package com.example.storedemo.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun<T> MutableLiveData<T>.toLiveData(): LiveData<T> = this