package com.example.kotlinexample.activities

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinexample.R
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat
import java.util.*

class DateActivity : BaseActivity() {

    companion object{
        val TAG:String = DateActivity::class.java.simpleName
    }
    var dateFormate = SimpleDateFormat("dd MMM, YYYY",Locale.US)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        Log.i(TAG,"onCreate")
        btnSelectDate.setOnClickListener {
            val now = Calendar.getInstance()

            val datePicker = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year,month,dayOfMonth)
                val date = dateFormate.format(selectedDate.time)
                btnSelectDate.text = date
                Toast.makeText(this,date,Toast.LENGTH_LONG).show()
            },now.get(Calendar.YEAR),now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"OnResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i(TAG,"OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG,"OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"OnDestroy")
    }
}
