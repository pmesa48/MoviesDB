package com.pmesa.moviesdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflateForViewHolder(resourceId: Int): View =
    LayoutInflater.from(context).inflate(resourceId, this, false)
