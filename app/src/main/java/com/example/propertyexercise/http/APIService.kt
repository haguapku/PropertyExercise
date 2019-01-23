package com.example.propertyexercise.http

import com.example.propertyexercise.model.Properties
import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

interface APIService {

    @Headers("Cache-Control: public, max-age=60 * 60 * 24 * 7")
    @GET("/test/properties")
    fun getProperty(): Observable<Properties>

}