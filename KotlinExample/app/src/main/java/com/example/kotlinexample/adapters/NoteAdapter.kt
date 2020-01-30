package com.example.kotlinexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample.R
import com.example.kotlinexample.entities.Note
import kotlinx.android.synthetic.main.note_item.view.*
import kotlinx.android.synthetic.main.ui_item.view.*

class NoteAdapter():RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {
    private var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_noteTitle.text = notes[position].title
        holder.tv_noteDescription.text = notes[position].description
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tv_noteTitle: TextView = itemView.tv_noteTitle
        var tv_noteDescription: TextView = itemView.tv_noteDescription
    }

    fun setNotes(notes:List<Note>)
    {
        this.notes = notes
        notifyDataSetChanged()
    }

}