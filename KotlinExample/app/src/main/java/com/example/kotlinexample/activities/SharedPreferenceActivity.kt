package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinexample.R
import com.example.kotlinexample.utils.SharedPreference
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        //Share preference value save
        val sharedPreference: SharedPreference =SharedPreference(this)

        btn_saveToSharedPref.setOnClickListener {
            if(et_Name.text.toString().length > 0)
            {
                //Save value
                sharedPreference.save("nameKey",et_Name.text.toString())
            }
            else
            {
                Toast.makeText(this,"Please enter name", Toast.LENGTH_SHORT).show()
            }
        }

        btn_retrivedFromSP.setOnClickListener {
            if (sharedPreference.getValueString("nameKey")!=null) {
                val retreivedValue:String = sharedPreference.getValueString("nameKey")!!
                et_Name.setText(retreivedValue)
            }
            else
            {
                Toast.makeText(this,"No value save in shared preference", Toast.LENGTH_SHORT).show()
            }
        }

        btn_clearSP.setOnClickListener {
            // For Clear All Share preference value
            sharedPreference.clearSharedPreference()
        }
    }
}
