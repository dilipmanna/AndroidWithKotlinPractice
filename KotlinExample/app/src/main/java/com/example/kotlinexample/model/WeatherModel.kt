package com.example.kotlinexample.model

data class WeatherModel(
    val consolidated_weather: List<ConsolidatedWeather>,
    val time: String,
    val title: String,
    val woeid: Int
)