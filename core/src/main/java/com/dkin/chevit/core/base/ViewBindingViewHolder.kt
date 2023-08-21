package com.dkin.chevit.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class ViewBindingViewHolder<BINDING : ViewBinding, ITEM>(
    private val binding: BINDING,
    onCreateViewHolderListener: BINDING.(getItemPosition: () -> Int) -> Unit,
    private val onBindItem: BINDING.(ITEM) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.onCreateViewHolderListener(::getAdapterPosition)
    }

    fun bindItem(item: ITEM) {
        binding.onBindItem(item)
    }
}
