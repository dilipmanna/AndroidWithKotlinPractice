package com.example.kotlinexample.activities

import android.app.TimePickerDialog
import android.os.Bundle
import com.example.kotlinexample.R
import kotlinx.android.synthetic.main.activity_time.*
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity : BaseActivity() {

    var timeFormat = SimpleDateFormat("hh:mm a", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        btnSelectTime.setOnClickListener {
            val now = Calendar.getInstance()
            try {
                if(btnSelectTime.text != "Select Time") {
                    val date = timeFormat.parse(btnSelectTime.text.toString())
                    now.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                selectedTime.set(Calendar.MINUTE,minute)
                btnSelectTime.text = timeFormat.format(selectedTime.time)
            },now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),false)
            timePicker.show()
        }


    }
}
