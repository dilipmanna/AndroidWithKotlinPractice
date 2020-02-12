package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexample.R
import com.example.kotlinexample.adapters.CountryAdapter
import com.example.kotlinexample.model.Country
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_country_filter.*

class CountryFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_filter)

        val objectArrayString: String = resources.openRawResource(R.raw.countrynamecode).bufferedReader().use { it.readText() }
        val countryList = Gson().fromJson(objectArrayString, Array<Country>::class.java).toList()


        val countryAdapter = CountryAdapter(this,android.R.layout.simple_list_item_1,countryList)
        autoCompleteTextView.setAdapter(countryAdapter)
        autoCompleteTextView.threshold = 1

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedCountry:Country = parent.adapter.getItem(position) as Country
            autoCompleteTextView.setText(selectedCountry.name)
        }
    }
}
