package com.example.myapplication3.classes

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication3.R
import com.example.myapplication3.objects.CitiesDB

class MyClickListener : View.OnClickListener {
    public lateinit var context: Context
    override fun onClick(v: View?) {
        CitiesDB.position++
        //val nav_host_fragment : NavHostFragment = context.activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //val nav_controller : NavController = nav_host_fragment.navController
        Log.v("This is from my onclick", "Hi")
    }
}