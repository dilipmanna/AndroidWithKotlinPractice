package com.example.kotlinexample.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinexample.R
import com.example.kotlinexample.adapters.LocationAdapter
import com.example.kotlinexample.model.Location
import com.example.kotlinexample.utils.ProjectConstant
import com.example.kotlinexample.viewModel.WeatherActivityViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : BaseActivity() {

    companion object{
        val TAG:String = WeatherActivity::class.java.simpleName
    }

    private lateinit var viewModel:WeatherActivityViewModel
    private var locationAdapter = LocationAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        Log.i(TAG,"OnCreated")

        iv_search.setOnClickListener {
            if(et_location.text.toString().isNotEmpty())
                viewModel.searchLocation(et_location.text.toString())
            else
                Toast.makeText(this, "Please enter serach text", Toast.LENGTH_SHORT).show()
        }

        viewModel = ViewModelProvider(this).get(WeatherActivityViewModel::class.java)
        viewModel.locationList.observe(this, Observer {
            locationAdapter.setLocationList(it)
        })

        viewModel.showProgress.observe(this, Observer {
            if(it)
                showProgressDialog();
            else
                hideProgressDialog()
        })

        rv_location.layoutManager = LinearLayoutManager(this)
        rv_location.adapter = locationAdapter
        locationAdapter.onItemClick = {
            locationItemClicked(it)
        }
    }

    private fun locationItemClicked(it: Location) {
        val extras = Bundle()
        extras.putInt(ProjectConstant.LOCATION_WOEID, it.woeid)
        goToNext(WeatherDetailsActivity::class.java, extras)
    }
}
