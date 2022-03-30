package br.com.felipepalma14.eventour.features.events.home.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.felipepalma14.eventour.features.events.databinding.ItemEventBinding
import br.com.felipepalma14.eventour.features.events.domain.model.EventData

class EventListAdapter(
    val onClick: (EventData) -> Unit
) : ListAdapter<EventData,
        RecyclerView.ViewHolder>(GridViewDiffCallback) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = getItem(position)
        (holder as MsgViewHolder).bind(product)
        holder.itemView.setOnClickListener { onClick(product) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        return MsgViewHolder(
            ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class MsgViewHolder constructor(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EventData) {
            binding.event = item
            binding.executePendingBindings()
        }
    }

    companion object GridViewDiffCallback : DiffUtil.ItemCallback<EventData>() {
        override fun areItemsTheSame(oldItem: EventData, newItem: EventData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EventData, newItem: EventData): Boolean {
            return oldItem == newItem
        }
    }
}