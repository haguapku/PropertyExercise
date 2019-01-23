package com.example.propertyexercise.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.propertyexercise.R
import com.example.propertyexercise.databinding.ItemHolderViewBinding
import com.example.propertyexercise.model.Listing
import com.example.propertyexercise.util.OnItemClick

class MyAdapter : RecyclerView.Adapter<MyHolder>() {

    override fun onBindViewHolder(p0: MyHolder, position: Int) {
        p0.binding!!.propertyList = listOld[position]
        p0.binding!!.viewPager.adapter = ImgPagerAdapter(
                listOld[position].ImageUrls.filter { it.endsWith(".jpg",false) })
    }

    private var listOld: List<Listing> = ArrayList()

    private var click: OnItemClick? = null

    fun add(list: List<Listing>) {
        listOld = list
        notifyItemRangeChanged(0,list.size)
    }

    override fun getItemCount(): Int {
        return listOld.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): MyHolder {
        val itemHolderViewBinding: ItemHolderViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(p0.context), R.layout.item_holder_view,p0,false)
        return MyHolder(itemHolderViewBinding,click!!)
    }


    fun setItemClick(click: OnItemClick) {
        this.click = click
    }
}