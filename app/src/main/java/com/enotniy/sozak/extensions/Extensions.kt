package com.enotniy.sozak.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.enotniy.sozak.modules.GlideApp

/**
 *Created by ekitselyuk on 04/06/2018
 */

fun Context.loadImage(view: ImageView, path: String, placeholder: Int) {
    GlideApp.with(this)
            .load(path)
            .useAnimationPool(true)
            .circleCrop()
            .placeholder(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(view)
}
