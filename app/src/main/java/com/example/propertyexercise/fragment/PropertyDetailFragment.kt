package com.example.propertyexercise.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.propertyexercise.R
import kotlinx.android.synthetic.main.propertyid_frament_view.view.*

class PropertyDetailFragment: Fragment(){

    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = arguments!!.getString("ID")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.propertyid_frament_view,container,false)
        view.propertyid.text = id
        return view
    }

}