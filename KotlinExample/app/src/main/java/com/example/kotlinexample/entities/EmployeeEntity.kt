package com.example.kotlinexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class EmployeeEntity (
    @PrimaryKey
    val id : Int,
    val email : String,
    val first_name : String,
    val last_name : String,
    val avatar : String
)