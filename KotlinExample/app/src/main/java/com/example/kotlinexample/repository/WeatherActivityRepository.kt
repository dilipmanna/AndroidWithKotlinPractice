package com.example.kotlinexample.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinexample.model.Location
import com.example.kotlinexample.model.SampleModel
import com.example.kotlinexample.networking.APIService
import com.example.kotlinexample.networking.APIServiceInterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.metaweather.com/api/location/"
class WeatherActivityRepository(val application: Application) {
    val showProgress =  MutableLiveData<Boolean>()
    val locationList = MutableLiveData<List<Location>>()

    fun searchLocation(searchStr : String){
        showProgress.value = true
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(APIServiceInterface::class.java)

        val requestCall: Call<List<Location>> = service.getLocation(searchStr)
        requestCall.enqueue(object: Callback<List<Location>> {
            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error wile accessing the API", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Location>>, response: Response<List<Location>>) {
                if(response.isSuccessful) {
                    Log.d("SearchRepository" , "Response : ${Gson().toJson(response.body())}")
                    locationList.value = response.body()
                    showProgress.value = false
                }
            }
        } )
    }
}