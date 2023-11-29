package com.example.storedemo.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadFromUrl(url: String?) {
    Glide
        .with(this.context)
        .load(url)
        .centerCrop()
        .into(this)
}