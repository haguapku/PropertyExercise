package com.example.propertyexercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.propertyexercise.fragment.PropertyDetailFragment

class PropertyDetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_detail)
        if (savedInstanceState == null){
            val propertyIdFragment = PropertyDetailFragment()
            val bundle = Bundle()
            bundle.putString("ID",intent.getStringExtra("ID"))
            propertyIdFragment.arguments = bundle
            supportFragmentManager.beginTransaction().add(R.id.detail_container,propertyIdFragment).commit()
        }
    }
}