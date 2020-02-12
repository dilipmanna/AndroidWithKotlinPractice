package com.example.kotlinexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.example.kotlinexample.model.Country

class CountryAdapter(context: Context, @LayoutRes private val layoutResource:Int, private val countryList:List<Country>)
    : ArrayAdapter<Country>(context,layoutResource,countryList), Filterable {

    private var mCountryList:List<Country> = countryList

    override fun getCount(): Int = mCountryList.size
    override fun getItem(position: Int): Country? {
        return mCountryList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val view: TextView = convertView as TextView? ?: LayoutInflater.from(context).inflate(layoutResource, parent, false) as TextView
        view.text = "${mCountryList[position].name} ${mCountryList[position].dial_code} (${mCountryList[position].code})"
        return view
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val queryString = constraint?.toString()?.toLowerCase()
                val filterResults = Filter.FilterResults()
                filterResults.values = if (queryString==null || queryString.isEmpty())
                    countryList
                else
                    countryList.filter {
                        it.name.toLowerCase().contains(queryString) ||
                                it.name.toLowerCase().contains(queryString) ||
                                it.dial_code.toLowerCase().contains(queryString) ||
                                it.code.toLowerCase().contains(queryString)
                    }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mCountryList = results?.values as List<Country>
                notifyDataSetChanged()
            }

        }
    }
}