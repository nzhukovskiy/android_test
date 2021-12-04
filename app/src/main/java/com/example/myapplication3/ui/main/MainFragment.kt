package com.example.myapplication3.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.MainActivity
import com.example.myapplication3.R
import com.example.myapplication3.RecyclerAdapter
//import com.example.myapplication3.common.Common
import com.example.myapplication3.interfaces.RetrofitInterface
import com.example.myapplication3.objects.RetrofitClient
import com.example.myapplication3.pojo.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var nav_controller: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        //val recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        //val strings : List<String> = listOf("hello", "friend")
        //Log.v("hi", "man2")
        //recyclerView.layoutManager = LinearLayoutManager(activity)
        //recyclerView.adapter = RecyclerAdapter(strings)


        val nav_host_fragment : NavHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val nav_controller : NavController = nav_host_fragment.navController
    //val nav_conrtoller : NavController = view?.findNavController().
       // val act : FragmentActivity? = activity
        val btn : Button = root.findViewById(R.id.button)
        //btn.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_blankFragment))
        btn.setOnClickListener {
            nav_controller.navigate(R.id.action_mainFragment_to_blankFragment)
        }

            //view.findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
            //it.setBackgroundColor(R.color.colorAccent)


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
