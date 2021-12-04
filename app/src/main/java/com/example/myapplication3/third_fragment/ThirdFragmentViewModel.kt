package com.example.myapplication3.third_fragment

import androidx.lifecycle.ViewModel
import com.example.myapplication3.pojo.City

class ThirdFragmentViewModel : ViewModel() {
    var cities : MutableList<City>? = mutableListOf<City>()
    var position : Int = 0
    // TODO: Implement the ViewModel
}