package com.example.kotlinexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinexample.R
import com.example.kotlinexample.entities.EmployeeEntity
import com.example.kotlinexample.model.AndroidUI
import com.example.kotlinexample.model.Employee
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.employee_item.view.*
import kotlinx.android.synthetic.main.ui_item.view.*



class EmployeeListAdapter(var employeeList:List<EmployeeEntity>, var context:Context): RecyclerView.Adapter<EmployeeListAdapter.MyViewHolder>()
{
    var OnItemClick:((EmployeeEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.employee_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = employeeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_employeeName.text = "${employeeList[position].first_name} ${employeeList[position].last_name}"
        holder.tv_employeeEmail.text = employeeList[position].email.toString()
       // Picasso.get().load(employeeList[position].avatar).into(holder.iv_employeeImg)
        Glide.with(context).load(employeeList[position].avatar).into(holder.iv_employeeImg);
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tv_employeeName: TextView = itemView.tv_employeeName
        var tv_employeeEmail: TextView = itemView.tv_employeeEmail
        var iv_employeeImg: ImageView = itemView.iv_employeeImg

        init {
            itemView.setOnClickListener{
                OnItemClick?.invoke(employeeList[adapterPosition])
            }

        }
    }
}