package com.example.kotlinexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import com.example.kotlinexample.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog.*

class BottomSheetDialogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_dialog)

        btn_bottomSheetDialog.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog,null)
            val close = view.findViewById<ImageView>(R.id.iv_close)
            close.setOnClickListener {
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setCancelable(false)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
        }

        btn_popupMenu.setOnClickListener {
            val popupMenu = PopupMenu(this,btn_popupMenu)
            popupMenu.inflate(R.menu.test)
            popupMenu.setOnMenuItemClickListener {
                Toast.makeText(this,it.title,Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()

        }

    }
}
