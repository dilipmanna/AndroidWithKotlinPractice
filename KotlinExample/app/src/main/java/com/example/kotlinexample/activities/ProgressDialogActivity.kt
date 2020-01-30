package com.example.kotlinexample.activities

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.kotlinexample.R

class ProgressDialogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_dialog)

//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Downloading...")
//        progressDialog.setCancelable(false)
//        progressDialog.show()
//        Handler().postDelayed({progressDialog.dismiss()},5000)

        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
        val message = dialogView.findViewById<TextView>(R.id.tvProgressBarMessage)
        message.text = "Downloading..."
        builder.setView(dialogView)
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.show()
        Handler().postDelayed({dialog.dismiss()},5000)
    }
}
