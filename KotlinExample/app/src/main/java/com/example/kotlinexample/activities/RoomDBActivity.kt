package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexample.R
import com.example.kotlinexample.database.ProjectDB
import com.example.kotlinexample.entities.TodoEntity
import kotlinx.android.synthetic.main.activity_room_db.*
import java.lang.StringBuilder

class RoomDBActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_db)

        val db = ProjectDB.getInstance(this)


        db!!.todoDao().deleteAll()

        for(i in 1..10)
        {
            val todoEntity = TodoEntity(id = 0,title = "Title${i}",content = "Content${i}")
            db!!.todoDao().insert(todoEntity)
        }

        val list = db!!.todoDao().getAll()

        var displayStr:StringBuilder = StringBuilder()
        for (i in 0..list.size - 1) {
            displayStr.append(list[i].id.toString()  +  list[i].title + list[i].content)
        }
        tv_displayMsg.text = displayStr.toString()

    }
}
