package com.binar.latihanmvvm.network

import com.binar.latihanmvvm.model.GetAllUser
import com.binar.latihanmvvm.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>
}