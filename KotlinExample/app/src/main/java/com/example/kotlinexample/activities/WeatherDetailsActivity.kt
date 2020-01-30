package com.example.kotlinexample.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinexample.R
import com.example.kotlinexample.utils.ProjectConstant
import com.example.kotlinexample.viewModel.WeatherDetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_weather_details.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class WeatherDetailsActivity : BaseActivity() {

    var dateFormate = SimpleDateFormat("dd MMM, yyyy - hh:mm a", Locale.US)
    var server_dateFormate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S", Locale.US)
    private lateinit var viewModel:WeatherDetailsActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        //get data from intent
        val woeid = intent.getIntExtra(ProjectConstant.LOCATION_WOEID,0)

        viewModel = ViewModelProvider(this).get(WeatherDetailsActivityViewModel::class.java)
        viewModel.weatherModel.observe(this, Observer {
            tv_location.text = it.title
            tv_temp.text = DecimalFormat("#.##").format(it.consolidated_weather[0].the_temp) + "\u00B0" + "C"
            val date = server_dateFormate.parse(it.time)
            tv_dateTime.text = dateFormate.format(date)
        })

        viewModel.showProgress.observe(this, Observer {
            if(it)
                showProgressDialog();
            else
                hideProgressDialog()
        })

        //getWeather
        viewModel.getWeather(woeid)
    }
}
