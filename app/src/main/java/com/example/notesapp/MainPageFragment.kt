package com.example.notesapp

import android.os.Bundle
import android.os.ParcelUuid
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.note_card_layout.view.*
import java.util.*

class MainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
        setToolbarTitle()
        setupFabAction(view)
        setupNotesView(view)

        // Inflate the layout for this fragment
        return view
    }

    private fun setToolbarTitle() {
        val toolbarView = activity?.findViewById<Toolbar>(R.id.toolbar)
        val textView = toolbarView?.findViewById<TextView>(R.id.toolbar_title)
        textView?.text = getString(R.string.main_page_title)
    }

    private fun setupFabAction(view: View) {
        view.findViewById<FloatingActionButton>(R.id.new_note_fab)?.setOnClickListener {
            Toast.makeText(context, getString(R.string.create_note_toast), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupNotesView(view: View) {
        val values = arrayOf(
            Note(ParcelUuid(UUID.randomUUID()),"Note 1", "Description 1"),
            Note(ParcelUuid(UUID.randomUUID()),"Note 2", "Description 2"),
            Note(ParcelUuid(UUID.randomUUID()),"Note 3", "Description 3")
        )

        val noteListLayoutManager = LinearLayoutManager(activity)
        val noteListView = view.findViewById<RecyclerView>(R.id.note_list).apply {
            layoutManager = noteListLayoutManager
            adapter = NotesListAdapter(values, ::bindNotesViewHolder)
        }

        noteListView.addItemDecoration(
            DividerItemDecoration(noteListView.context, noteListLayoutManager.orientation)
        )
    }

    private fun bindNotesViewHolder(holder: NotesListAdapter.NotesListViewHolder, note: Note) {
        val noteCard = holder.view as LinearLayout
        noteCard.note_title.text = note.title
        noteCard.note_description.text = note.description
        noteCard.setOnClickListener {
            val action = MainPageFragmentDirections.actionMainPageFragmentToNotePageFragment(
                note.id
            )
            findNavController().navigate(action)
        }
    }
}