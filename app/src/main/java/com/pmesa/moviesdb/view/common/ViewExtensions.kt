package com.pmesa.moviesdb.view.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

fun ViewGroup.inflate(resourceId: Int): View =
    LayoutInflater.from(context).inflate(resourceId, this, false)


fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}
