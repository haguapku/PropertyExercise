package com.example.propertyexercise.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.propertyexercise.http.RetrofitManager
import com.example.propertyexercise.model.Listing
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class PropertyRepository{

    private val listProperty : MutableLiveData<List<Listing>> = MutableLiveData()

    fun getPropertyList() : LiveData<List<Listing>> {

        RetrofitManager.builder("https://demo7442132.mockable.io")
                .getProperties()
                .flatMap{it -> Observable.just(it.data.listings)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ a ->
                    listProperty.setValue(a)
                },{ throwable -> println("----error-----" + throwable.message) })
        return listProperty
    }
}