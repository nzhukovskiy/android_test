package com.example.myapplication3



import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.classes.MyClickListener
import com.example.myapplication3.pojo.City

class RecyclerAdapter (private val cities: MutableList<City>?) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){
    var inner_cities : MutableList<City>? = cities
    var onItemClick : ((City) -> Unit)? = null
    var pos : Int = 0
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myTextView : TextView? = null

        init{
            myTextView = itemView.findViewById(R.id.recyclerElText)
            itemView.setOnClickListener {
                pos = adapterPosition
                onItemClick?.invoke(inner_cities!![adapterPosition])
            }
        }
    }
    private val my_click_listener = MyClickListener()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.v("hi", "friend")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        //itemView.setOnClickListener(my_click_listener)
        return MyViewHolder((itemView))
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.v("hi2", "friend")
        holder.myTextView?.text = cities!![position].Name
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return cities!!.size
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}