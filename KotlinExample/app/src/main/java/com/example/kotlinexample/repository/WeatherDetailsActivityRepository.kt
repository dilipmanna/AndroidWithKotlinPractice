package com.example.kotlinexample.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlinexample.model.WeatherModel
import com.example.kotlinexample.networking.APIServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherDetailsActivityRepository(val application: Application) {

    val showProgress =  MutableLiveData<Boolean>()
    val weatherModel = MutableLiveData<WeatherModel>()

    fun getWeather(woeId : Int){
        showProgress.value = true
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(APIServiceInterface::class.java)

        val requestCall: Call<WeatherModel> = service.getWeather(woeId)
        requestCall.enqueue(object: Callback<WeatherModel> {
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error wile accessing the API", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                if(response.isSuccessful) {
                    //Log.d("WeatherDetailRepository" , "Response : ${Gson().toJson(response.body())}")
                    weatherModel.value = response.body()
                    showProgress.value = false
                }
            }
        } )
    }

}