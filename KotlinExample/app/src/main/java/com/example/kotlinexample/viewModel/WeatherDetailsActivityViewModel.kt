package com.example.kotlinexample.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinexample.model.WeatherModel
import com.example.kotlinexample.repository.WeatherDetailsActivityRepository

class WeatherDetailsActivityViewModel (application: Application):AndroidViewModel(application){
    val repository = WeatherDetailsActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val weatherModel: LiveData<WeatherModel>
    init {
        this.showProgress = repository.showProgress;
        this.weatherModel = repository.weatherModel;
    }
    fun getWeather(woeId : Int){
        repository.getWeather(woeId)
    }

}