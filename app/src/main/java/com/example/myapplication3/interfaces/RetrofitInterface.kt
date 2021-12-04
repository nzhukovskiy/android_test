package com.example.myapplication3.interfaces
import retrofit2.Call
import retrofit2.http.GET
import com.example.myapplication3.pojo.City
import retrofit2.Response

interface RetrofitInterface {
    @GET("City.json")
    suspend fun getCities() : Response<MutableList<City>> ;
}