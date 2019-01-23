package com.example.propertyexercise.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.propertyexercise.R
import com.example.propertyexercise.adapter.MyAdapter
import com.example.propertyexercise.model.Listing
import com.example.propertyexercise.util.OnItemClick
import com.example.propertyexercise.viewmodel.PropertyViewModel
import kotlinx.android.synthetic.main.propertiesfragment_view.view.*


class PropertyListFragment: Fragment(), OnItemClick {

    private lateinit var adapter: MyAdapter

    private lateinit var listProperty : List<Listing>
    private lateinit var propertyViewModel: PropertyViewModel

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.propertiesfragment_view, container, false)
        adapter = MyAdapter()
        val recyclerView = view.recyclerView
        val manager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = manager
        adapter.setItemClick(this)
        recyclerView.adapter = adapter

        propertyViewModel = ViewModelProviders.of(this).get(PropertyViewModel::class.java)
        propertyViewModel.getPropertyList().observe(this, Observer<List<Listing>>{ it ->
            listProperty = it!!
            adapter.add(it)
        })
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onItemClick(view: View, position: Int) {
        mListener!!.onFragmentInteraction(listProperty[position].Id)
    }

    interface OnFragmentInteractionListener{

        fun onFragmentInteraction(id: String)
    }
}