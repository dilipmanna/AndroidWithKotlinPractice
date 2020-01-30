package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinexample.R
import com.example.kotlinexample.dbhelper.DataBaseHandler
import com.example.kotlinexample.model.User
import kotlinx.android.synthetic.main.activity_sqlite.*

class SqliteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        var db = DataBaseHandler(this)
        btn_insert.setOnClickListener {
            if(etName.text.toString().length > 0 && etAge.text.toString().length > 0)
            {
                var user = User(0,etName.text.toString(),etAge.text.toString().toInt())
                db.insertData(user)
            }
            else {
                Toast.makeText(this,"Please Fill All Data's",Toast.LENGTH_SHORT).show()
            }
        }

        btn_read.setOnClickListener({
            var data = db.readData()
            tvResult.text = ""
            for (i in 0..(data.size - 1)) {
                tvResult.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).age + "\n")
            }
        })

        btn_update.setOnClickListener({
            db.updateData()
            btn_read.performClick()
        })

        btn_delete.setOnClickListener({
            db.deleteData()
            btn_read.performClick()
        })
    }
}
