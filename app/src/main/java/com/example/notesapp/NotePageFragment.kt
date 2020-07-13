package com.example.notesapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson

class NotePageFragment : Fragment() {

    private val args: NotePageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val note = loadNote()
        setToolbarTitle(note)
        return inflater.inflate(R.layout.fragment_note_page, container, false)
    }

    private fun loadNote(): Note {
        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.notes_store_key),
            Context.MODE_PRIVATE
        )
        // Need to handle null case
        val serialisedNote = sharedPref?.getString(args.noteId.toString(), null)
        return Gson().fromJson(serialisedNote, Note::class.java)
    }

    private fun setToolbarTitle(note: Note) {
        val toolbarView = activity?.findViewById<Toolbar>(R.id.toolbar)
        val textView = toolbarView?.findViewById<TextView>(R.id.toolbar_title)
        textView?.text = note.title
    }
}