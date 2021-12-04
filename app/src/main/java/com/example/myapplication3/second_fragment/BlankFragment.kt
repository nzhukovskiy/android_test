package com.example.myapplication3.second_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.HorizontalRecyclerAdapter
import com.example.myapplication3.MainActivity
import com.example.myapplication3.R
import com.example.myapplication3.RecyclerAdapter
import com.example.myapplication3.interfaces.RetrofitInterface
import com.example.myapplication3.objects.CitiesDB
import com.example.myapplication3.objects.RetrofitClient
import com.example.myapplication3.pojo.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel
    private lateinit var recyclerView : RecyclerView
    private lateinit var horRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.blank_fragment, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        val strings : List<String> = listOf("hello54", "friend", "another")
        //val base_url= "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/"
        //val retrofitService: Retrofit = RetrofitClient.getClient(base_url)
        //var my_service = retrofitService.create(RetrofitInterface::class.java)
        //var cities : MutableList<City>? = mutableListOf<City>()
        val nav_host_fragment : NavHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val nav_controller : NavController = nav_host_fragment.navController

        viewModel.make_request().observe(viewLifecycleOwner, {
            CitiesDB.cities = it
            horRecyclerView = root.findViewById(R.id.recyclerView_horizontal)
            val hor_adapter = HorizontalRecyclerAdapter(CitiesDB.cities)

            horRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            horRecyclerView.adapter = hor_adapter

            val adapter : RecyclerAdapter = RecyclerAdapter(CitiesDB.cities)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter

            adapter.onItemClick = {
                nav_controller.navigate(R.id.action_blankFragment_to_third_fragment)
                CitiesDB.position = adapter.pos
            }
        })
        /*my_service.getCities().enqueue(object: Callback<MutableList<City>> {
            override fun onFailure(call: Call<MutableList<City>>, t: Throwable) {
                val textView: TextView = root.findViewById(R.id.my_text)
                textView.setText(t.message)
            }

            override fun onResponse(
                call: Call<MutableList<City>>,
                response: Response<MutableList<City>>
            ) {
                //viewModel.cities = response.body()
                CitiesDB.cities = response.body()
                //(activity as MainActivity).cities.cities = response.body();
                val adapter : RecyclerAdapter = RecyclerAdapter(CitiesDB.cities)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = adapter

                adapter.onItemClick = {
                    nav_controller.navigate(R.id.action_blankFragment_to_third_fragment)
                    CitiesDB.position = adapter.pos
                }
                /*val textView: TextView = root.findViewById(R.id.my_text)
                if (cities != null)
                {
                    textView.setText(cities[2].Country)
                }
                else {
                    textView.setText("Error")
                }*/

            }
        })*/
        Log.v("hi", "man2")



        val text_view : TextView = root.findViewById(R.id.blank_fragment_text)
        //text_view.setOnClickListener{
            //nav_controller.navigate(R.id.action_blankFragment_to_third_fragment)
        //}
        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        //recyclerView.layoutManager = LinearLayoutManager(activity)
        //recyclerView.adapter = RecyclerAdapter(viewModel.cities)
        // TODO: Use the ViewModel
    }

}