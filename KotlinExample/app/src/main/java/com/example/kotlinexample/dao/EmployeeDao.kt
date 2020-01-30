package com.example.kotlinexample.dao

import androidx.room.*
import com.example.kotlinexample.entities.EmployeeEntity

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getAll():List<EmployeeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg employees: EmployeeEntity)

    @Delete
    fun delete(employee: EmployeeEntity)
    @Query("DELETE FROM employee")
    fun deleteAll()


    @Update
    fun update( employee: EmployeeEntity)
    @Update
    fun updateAll(vararg employees: EmployeeEntity)
}