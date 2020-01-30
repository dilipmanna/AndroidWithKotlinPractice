package com.example.kotlinexample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LiveDataViewModel:ViewModel() {
    val currentRandomNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun getNumber():MutableLiveData<Int>{
        if(currentRandomNumber == null)
            createNumber()
         return currentRandomNumber
    }

    public fun createNumber() {
        val myRandomNumber = Random.nextInt(0,10) + 1
        currentRandomNumber.setValue(myRandomNumber)
    }

}