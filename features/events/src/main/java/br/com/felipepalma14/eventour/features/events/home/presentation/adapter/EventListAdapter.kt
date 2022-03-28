package br.com.felipepalma14.eventour.features.events.home.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.felipepalma14.eventour.features.events.databinding.ItemEventBinding
import br.com.felipepalma14.eventour.features.events.domain.model.EventData

class EventListAdapter(private val clickListener: OnClickListener) : ListAdapter<EventData,
        RecyclerView.ViewHolder>(GridViewDiffCallback) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = getItem(position)
        (holder as MsgViewHolder).bind(clickListener, product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        return MsgViewHolder(
            ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class MsgViewHolder constructor(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: OnClickListener, item: EventData) {
            binding.event = item
            // binding.clickListener  = clickListener
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

    class OnClickListener(val clickListener: (item: EventData) -> Unit) {
        fun onClick(v: View, item: EventData) = clickListener(item)
    }

}