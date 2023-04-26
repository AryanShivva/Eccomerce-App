package com.example.a26api

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("products")                        //last word of api url
    fun getProductData() : Call<MyData>
}