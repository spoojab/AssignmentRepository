package com.example.naviproject.utils

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import coil.transform.CircleCropTransformation

object ImageWidgetUtils {

    fun loadRoundedImageAsync(
        view: AppCompatImageView,
        url: String?,
        @DrawableRes defaultImageResId: Int
    ) {
        view.load(url) {
            crossfade(true)
            fallback(defaultImageResId)
            transformations(CircleCropTransformation())
        }
    }
}