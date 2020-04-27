package com.example.recyclerviewexample

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.image_view
    val textView1: TextView = itemView.text_view_1
    val textView2: TextView = itemView.text_view_2
}