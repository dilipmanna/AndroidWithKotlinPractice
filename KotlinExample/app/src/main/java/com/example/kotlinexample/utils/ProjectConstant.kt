package com.example.kotlinexample.utils

import com.example.kotlinexample.model.AndroidUI

class ProjectConstant {
    companion object{
        val uilist = listOf<AndroidUI>(
            AndroidUI("Date From Calender"),
            AndroidUI("Time From Clock"),
            AndroidUI("ProgressDialog"),
            AndroidUI("Full Screen Progress Bar"),
            AndroidUI("BottomSheetDialog"),
            AndroidUI("Fragment"),
            AndroidUI("NavigationDrawer"),
            AndroidUI("BottomNavigation"),
            AndroidUI("MaterialTabs"),
            AndroidUI("Custom Filtered Adapter"),
            AndroidUI("Sqlite"),
            AndroidUI("RoomDB"),
            AndroidUI("Retrofit"),
            AndroidUI("SharedPreference"),
            AndroidUI("ViewModel & LiveData"),
            AndroidUI("Simple Notes MVVM"),
            AndroidUI("Weather-MVVM"),
            AndroidUI("Firebase-Auth")

        )
        var LOCATION_WOEID = "Location_Woeid" //woeid - Where On Earth ID
    }

}