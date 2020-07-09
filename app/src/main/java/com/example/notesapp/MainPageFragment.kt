package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.note_card_layout.view.*

class MainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
        setToolbarTitle()
        setupFabAction()
        setupNotesView(view)

        // Inflate the layout for this fragment
        return view
    }

    private fun setToolbarTitle() {
        val textView = activity?.findViewById<Toolbar>(R.id.toolbar)?.findViewById<TextView>(R.id.toolbar_title)
        textView?.text = getString(R.string.main_page_title)
    }

    private fun setupFabAction() {
        view?.findViewById<FloatingActionButton>(R.id.new_note_fab)?.setOnClickListener {
            Toast.makeText(context, getString(R.string.create_note_toast), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupNotesView(view: View) {
        val values = arrayOf(
            Note("Note 1"),
            Note("Note 2"),
            Note("Note 3")
        )
        view.findViewById<RecyclerView>(R.id.note_list).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NotesListAdapter(values, ::bindNotesViewHolder)
        }
    }

    private fun bindNotesViewHolder(holder: NotesListAdapter.NotesListViewHolder, note: Note) {
        (holder.view as LinearLayout).textView.text = note.description;
    }
}