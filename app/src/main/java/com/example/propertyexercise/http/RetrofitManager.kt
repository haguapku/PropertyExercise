package com.example.propertyexercise.http

import com.example.propertyexercise.model.Properties
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class RetrofitManager private constructor(url: String) {

    private var service: APIService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(APIService::class.java)
    }

    companion object {
        fun builder(url: String): RetrofitManager {
            return RetrofitManager(url)
        }
    }

    fun getProperties(): Observable<Properties> = service.getProperty()
}

