package com.example.propertyexercise.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.propertyexercise.model.Listing
import com.example.propertyexercise.repository.PropertyRepository

class PropertyViewModel(application: Application) : AndroidViewModel(application){

    private val propertyRepository = PropertyRepository()
    private var listProperty : LiveData<List<Listing>>? = MutableLiveData()

    fun getPropertyList() : LiveData<List<Listing>> {

        listProperty = propertyRepository.getPropertyList()
        return listProperty!!
    }
}