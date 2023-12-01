package com.example.utaronew.ui.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.utaronew.CostomClickListener
import com.example.utaronew.R

class GoroViewHolder(itemView: View, private val listener: CostomClickListener) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    private val name: TextView = itemView.findViewById(R.id.goro_name)
    private val image: ImageView = itemView.findViewById(R.id.goro_image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        listener.onCustomerClick(adapterPosition)
    }

    fun bind(text: String, text1: String) {
        name.text = text
        val imageResId = itemView.context.resources.getIdentifier(text1, "drawable", itemView.context.packageName)
        image.setImageResource(imageResId)
    }

    companion object {
        fun create(parent: ViewGroup, listener: CostomClickListener): GoroViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_goroscop, parent, false)
            return GoroViewHolder(view, listener)
        }
    }
}