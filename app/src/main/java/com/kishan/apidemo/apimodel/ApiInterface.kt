package com.kishan.apidemo.apimodel

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("quotes")
    fun getquotesdata() : Call<ApiData>
}