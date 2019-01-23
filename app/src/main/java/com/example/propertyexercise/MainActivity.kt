package com.example.propertyexercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.propertyexercise.fragment.PropertyDetailFragment
import com.example.propertyexercise.fragment.PropertyListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PropertyListFragment.OnFragmentInteractionListener {

    private var mDualPanel:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_list)
        //Check whether on conventional phone or not
        if (details != null){
            mDualPanel = true
        }

    }

    override fun onFragmentInteraction(id: String) {

        if (mDualPanel){
            val bundle = Bundle()
            bundle.putString("ID",id)
            val propertyIdFragment = PropertyDetailFragment()
            propertyIdFragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.details, propertyIdFragment)
            transaction.commit()
        }else{
            val intent = Intent(this,PropertyDetailActivity::class.java)
            intent.putExtra("ID",id)
            startActivity(intent)
        }


    }

}
