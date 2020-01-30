package com.example.kotlinexample.dao

import androidx.room.*
import com.example.kotlinexample.entities.TodoEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_items")
    fun getAll():List<TodoEntity>

    @Query("SELECT * FROM todo_items WHERE title LIKE :title")
    fun findByTitle(title: String): TodoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo:TodoEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todos: TodoEntity)

    @Delete
    fun delete(todo: TodoEntity)
    @Query("DELETE FROM todo_items")
    fun deleteAll()

    @Update
    fun update( todo: TodoEntity)
    @Update
    fun updateAll(vararg todos: TodoEntity)
}