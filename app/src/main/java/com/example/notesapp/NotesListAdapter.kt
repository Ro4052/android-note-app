package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class NotesListAdapter(private val notes: Array<Note>,
                       private val bindViewHolderCallback: (holder: NotesListViewHolder, note: Note) -> Unit) :
        RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder>() {

    class NotesListViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.note_card_layout, parent, false)

        return NotesListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        bindViewHolderCallback(holder, notes[position])
    }

    override fun getItemCount() = notes.size
}