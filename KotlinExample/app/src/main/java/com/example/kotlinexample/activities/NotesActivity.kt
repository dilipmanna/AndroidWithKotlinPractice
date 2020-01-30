package com.example.kotlinexample.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinexample.R
import com.example.kotlinexample.adapters.NoteAdapter
import com.example.kotlinexample.entities.Note
import com.example.kotlinexample.viewModel.NoteViewModel
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : BaseActivity() {

    private val ADD_NOTE_REQUEST = 1
    private lateinit var noteViewModel:NoteViewModel
    private val noteAdapter = NoteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

       // noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        btn_addNote.setOnClickListener {
            startActivityForResult(
                Intent(this,AddNoteActivity::class.java),
                ADD_NOTE_REQUEST
            )
        }
        recyclerView_notes.layoutManager = LinearLayoutManager(this)
        recyclerView_notes.adapter = noteAdapter

        noteViewModel.getAllNotes().observe(this, Observer<List<Note>> {
            noteAdapter.setNotes(it)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK && data != null)
        {
            val newNote = Note(
                data.getStringExtra(AddNoteActivity.EXTRA_TITLE),
                data.getStringExtra(AddNoteActivity.EXTRA_DESCRIPTION)
            )
            noteViewModel.insert(newNote)
            Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Note not saved!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            R.id.delete_all_notes ->{
                noteViewModel.deleteAllNotes()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }
}
