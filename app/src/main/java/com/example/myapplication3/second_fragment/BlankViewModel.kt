package com.example.myapplication3.second_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication3.interfaces.RetrofitInterface
import com.example.myapplication3.objects.RetrofitClient
import com.example.myapplication3.pojo.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class BlankViewModel : ViewModel() {
    var cities : MutableList<City>? = mutableListOf<City>()
    //val base_url= "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/"
    //val retrofitService: Retrofit = RetrofitClient.getClient(base_url)
    //var my_service = retrofitService.create(RetrofitInterface::class.java)
    /*init{
        viewModelScope.launch(Dispatchers.IO) {
            val resp : Response<MutableList<City>> = my_service.getCities().execute()
            cities = resp.body()
        }
    }*/
    fun make_request() : LiveData<MutableList<City>> {

        val base_url= "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/"
        val retrofitService: Retrofit = RetrofitClient.getClient(base_url)
        var my_service = retrofitService.create(RetrofitInterface::class.java)
        return liveData {
            val data = my_service.getCities()
            data.body()?.let { emit(it) }
        }
        /*viewModelScope.launch(Dispatchers.IO) {
            val resp : Response<MutableList<City>> = my_service.getCities().execute()
            cities = resp.body()
        }*/

    }
    // TODO: Implement the ViewModel
}