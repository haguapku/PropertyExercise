package com.example.propertyexercise.adapter

import com.example.propertyexercise.util.OnItemClick
import com.example.propertyexercise.databinding.ItemHolderViewBinding

class MyHolder(itemHolderViewBinding: ItemHolderViewBinding, click: OnItemClick) : android.support.v7.widget.RecyclerView.ViewHolder(itemHolderViewBinding.root), android.view.View.OnClickListener {

    var binding: ItemHolderViewBinding?=null
    private var click: OnItemClick? = null

    init {
        binding = itemHolderViewBinding
        this.click = click
        itemHolderViewBinding.root.setOnClickListener(this)
    }

    override fun onClick(v: android.view.View?) {
        if (v != null) {
            click!!.onItemClick(v, adapterPosition)
        }
    }

}
