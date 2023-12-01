package com.example.utaronew.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.utaronew.data.room.entities.GoroscopListEntities
import com.example.utaronew.ui.view.HoroscopeMain

class GoroscopMainAdapter(var listener: HoroscopeMain): ListAdapter<GoroscopListEntities, GoroViewHolder>(GoroDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoroViewHolder {
        return GoroViewHolder.create(parent, listener)
    }


    override fun onBindViewHolder(holder: GoroViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name, current.image)
        holder.itemView.setOnClickListener{
            listener.onCustomerClick(position)
        }
    }

    class GoroDiff : DiffUtil.ItemCallback<GoroscopListEntities>() {
        override fun areItemsTheSame(
            oldItem: GoroscopListEntities,
            newItem: GoroscopListEntities
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: GoroscopListEntities,
            newItem: GoroscopListEntities
        ): Boolean {
            return oldItem.name == newItem.name
        }
    }

}

