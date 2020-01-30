package com.example.kotlinexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample.R
import com.example.kotlinexample.model.Location
import kotlinx.android.synthetic.main.weather_location_item.view.*

class LocationAdapter(var context: Context): RecyclerView.Adapter<LocationAdapter.MyViewHolder>() {

    var onItemClick :((Location) -> Unit)? = null

    private var locationList:List<Location> =ArrayList()
    fun setLocationList(list:List<Location>){
        this.locationList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_location_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = locationList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_locationTitle.text = locationList[position].title
        holder.tv_latt_long.text = locationList[position].latt_long
    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tv_locationTitle:TextView = itemView.tv_locationTitle
        val tv_latt_long:TextView = itemView.tv_latt_long

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(locationList[adapterPosition])
            }
        }
    }
}