package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api_response.Entry
import com.example.myapplication.databinding.ShowNotApprovedOrderLayoutBinding


class EntryAdapter : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {
    private var entries: List<Entry> = emptyList()

    fun setData(entries: List<Entry>) {
        this.entries = entries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val binding = ShowNotApprovedOrderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(entries[position])
    }

    override fun getItemCount(): Int = entries.size

    inner class EntryViewHolder(private val binding: ShowNotApprovedOrderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: Entry) {
            binding.textStoreName.text = entry.API
            binding.textNoOfProduct.text = entry.Link
            binding.textTotalValue.text = entry.Description
            // Bind other views with corresponding data from the 'entry' object
        }
    }
}
