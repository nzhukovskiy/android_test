package com.example.myapplication3.third_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication3.MainActivity
import com.example.myapplication3.R
import com.example.myapplication3.objects.CitiesDB

class Third_fragment : Fragment() {

    companion object {
        fun newInstance() = Third_fragment()
    }

    private lateinit var viewModel: ThirdFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.third_fragment_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ThirdFragmentViewModel::class.java)
        val text_view : TextView = root.findViewById(R.id.third_fragment_text)
        val text_view_country : TextView = root.findViewById(R.id.third_fragment_country)
        val text_view_population : TextView = root.findViewById(R.id.third_fragment_population)
        viewModel.cities = CitiesDB.cities
        viewModel.position = CitiesDB.position
        text_view.text = viewModel.cities!![viewModel.position].Name
        text_view_country.text = viewModel.cities!![viewModel.position].Country
        text_view_population.text = viewModel.cities!![viewModel.position].Population.toString()
        //viewModel.cities = (activity as MainActivity).cities.cities
        //viewModel.position = (activity as MainActivity).cities!!.position
        //text_view.text = viewModel.cities!![viewModel.position].Name
        //text_view.text = "hi"
        //text_view.text = (activity as MainActivity).cities!!.cities!![(activity as MainActivity).cities!!.position].Name
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}