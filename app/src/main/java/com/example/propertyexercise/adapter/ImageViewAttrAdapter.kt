package com.example.propertyexercise.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageViewAttrAdapter{

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                    .load(url)
                    .into(imageView)
        }
    }
}