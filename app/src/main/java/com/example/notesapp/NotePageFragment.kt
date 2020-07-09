package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class NotePageFragment : Fragment() {

    private val args: NotePageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        loadNote()
        return inflater.inflate(R.layout.fragment_note_page, container, false)
    }

    private fun loadNote() {
        Toast.makeText(context, args.noteId.toString(), Toast.LENGTH_SHORT).show()
    }
}