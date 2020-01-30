package com.example.kotlinexample.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinexample.model.Location
import com.example.kotlinexample.repository.WeatherActivityRepository

class WeatherActivityViewModel(application: Application):AndroidViewModel(application) {
    val repository = WeatherActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val locationList: LiveData<List<Location>>
    init {
        this.showProgress = repository.showProgress;
        this.locationList = repository.locationList;
    }

    fun searchLocation(searchStr : String){
        repository.searchLocation(searchStr)
    }

}