package com.example.kotlinexample.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.kotlinexample.R
import com.example.kotlinexample.fragment.BlueFragment
import com.example.kotlinexample.fragment.GreenFragment
import com.example.kotlinexample.fragment.RedFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        btn_red.setOnClickListener {
            resetBtnsColor()
            btn_red.setBackgroundColor(Color.RED)
            fragmentReplace(R.id.fragment_color_container_view,RedFragment())
        }
        btn_green.setOnClickListener {
            resetBtnsColor()
            btn_green.setBackgroundColor(Color.GREEN)
            fragmentReplace(R.id.fragment_color_container_view,GreenFragment())
        }
        btn_blue.setOnClickListener {
            resetBtnsColor()
            btn_blue.setBackgroundColor(Color.BLUE)
            fragmentReplace(R.id.fragment_color_container_view,BlueFragment())
        }
    }

    private fun resetBtnsColor() {
        btn_red.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlacktrans))
        btn_green.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlacktrans))
        btn_blue.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlacktrans))
    }

}
