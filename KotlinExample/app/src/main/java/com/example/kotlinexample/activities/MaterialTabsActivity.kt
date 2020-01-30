package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexample.R
import com.example.kotlinexample.activities.ui.home.HomeFragment
import com.example.kotlinexample.activities.ui.tools.ToolsFragment
import com.example.kotlinexample.adapters.ViewPagerAdapter
import com.example.kotlinexample.fragment.BlueFragment
import com.example.kotlinexample.fragment.GreenFragment
import com.example.kotlinexample.fragment.ProfileFragment
import com.example.kotlinexample.fragment.RedFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_material_tabs.*

class MaterialTabsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_tabs)

        setSupportActionBar(toolbarForTablayout)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(RedFragment(), "Red")
        adapter.addFragment(GreenFragment(), "Green")
        adapter.addFragment(BlueFragment(), "Blue")
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(ToolsFragment(), "Tools")
        adapter.addFragment(RedFragment(), "Red")
        adapter.addFragment(GreenFragment(), "Green")
        adapter.addFragment(BlueFragment(), "Blue")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
