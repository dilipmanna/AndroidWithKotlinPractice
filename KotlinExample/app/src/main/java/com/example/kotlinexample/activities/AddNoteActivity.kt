package com.example.kotlinexample.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlinexample.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "com.example.kotlinexample.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "com.example.kotlinexample.EXTRA_DESCRIPTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        return when(item.itemId){
            R.id.save_note ->{
                saveNote()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
        if (et_noteTitle.text.toString().trim().isBlank() || et_noteDescription.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }
        val data = Intent().apply {
            putExtra(EXTRA_TITLE, et_noteTitle.text.toString())
            putExtra(EXTRA_DESCRIPTION, et_noteDescription.text.toString())
        }
        setResult(Activity.RESULT_OK, data)
        finish()

    }
}
