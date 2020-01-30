package com.example.kotlinexample.model

import com.example.kotlinexample.entities.EmployeeEntity

data class SampleModel (
    val page : Int,
    val per_page : Int,
    val total : Int,
    val total_pages : Int,
    val data : List<EmployeeEntity>
)
data class Employee (
    val id : Int,
    val email : String,
    val first_name : String,
    val last_name : String,
    val avatar : String
)