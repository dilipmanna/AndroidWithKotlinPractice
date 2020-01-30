package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinexample.R
import com.example.kotlinexample.viewModel.LiveDataViewModel
import kotlinx.android.synthetic.main.activity_view_model.*
import kotlin.random.Random

class LiveDataActivity : AppCompatActivity() {

    companion object{
        val TAG:String = LiveDataActivity::class.java.simpleName
    }

    private  lateinit var model:LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        //tv_randomNumber.text = getNumber().toString()
        model = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)


        model.currentRandomNumber.observe(this, Observer {
            Log.i(TAG,"UI updated")
            tv_randomNumber.text = it.toString()
        })

        btn_randomNumberClick.setOnClickListener {
            Log.i(TAG,"random number created")
            model.createNumber()
        }
    }

}
