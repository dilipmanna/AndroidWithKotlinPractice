package com.example.kotlinexample.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.example.kotlinexample.R

class ProgressDialog(val context: Context) {
    var isShowing : Boolean = false
    val dialog = Dialog(context)
    fun DialogCreate(message:String)
    {
        dialog .requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog .setContentView(R.layout.loading_avi)
        dialog .setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val tv_message = dialog .findViewById(R.id.tv_message) as TextView
        tv_message.text = message
    }
    fun showProgressDialog()
    {
        dialog.show()
        isShowing = true
    }
    fun hideProgressDialog()
    {
        dialog .dismiss()
        isShowing = false
    }

}