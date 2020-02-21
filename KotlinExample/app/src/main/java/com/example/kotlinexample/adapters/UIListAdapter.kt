package com.example.kotlinexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample.R
import com.example.kotlinexample.model.AndroidUI
import kotlinx.android.synthetic.main.ui_item.view.*


class UIListAdapter(var uiList:List<AndroidUI>, var myInterface:OnItemClickInterface): RecyclerView.Adapter<UIListAdapter.MyViewHolder>()
{
   // var OnItemClick:((AndroidUI) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.ui_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = uiList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.btnItem.text = uiList[position].name
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var btnItem: Button = itemView.btnItem
        init {
            /*
            btnItem.setOnClickListener{
                OnItemClick?.invoke(uiList[adapterPosition])
            }*/
            btnItem.setOnClickListener {
                myInterface.OnItemClicked(uiList[adapterPosition])
            }
        }
    }
}
interface OnItemClickInterface{
    public fun OnItemClicked(androidUI: AndroidUI)
}