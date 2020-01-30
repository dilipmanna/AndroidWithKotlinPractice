package com.example.kotlinexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinexample.dao.EmployeeDao
import com.example.kotlinexample.dao.NoteDao
import com.example.kotlinexample.dao.TodoDao
import com.example.kotlinexample.entities.EmployeeEntity
import com.example.kotlinexample.entities.Note
import com.example.kotlinexample.entities.TodoEntity

@Database(entities = [TodoEntity::class,EmployeeEntity::class, Note::class],version = 1)
abstract  class ProjectDB:RoomDatabase() {
    abstract fun todoDao():TodoDao
    abstract fun employeeDao():EmployeeDao
    abstract fun noteDao():NoteDao
    companion object {

        private var INSTANCE: ProjectDB? = null

        fun getInstance(context: Context): ProjectDB? {
            if (INSTANCE == null) {
                synchronized(ProjectDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ProjectDB::class.java, "myDB.db"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}