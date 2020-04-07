package com.ghalym.databasesexample.SqliteExample.Note.displayNote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.data.Note
import com.ghalym.databasesexample.SqliteExample.Note.displayNote.NoteAdapter
import kotlinx.android.synthetic.main.activity_display_notes.*

class DisplayNotesActivity : AppCompatActivity(),
    IDisplayNoteView {
    lateinit var presenter: DisplayNotePresenter;
    lateinit var adapter: NoteAdapter;
    var data = ArrayList<Note>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_notes)
        presenter = DisplayNotePresenter(this, this);
        adapter = NoteAdapter(data);
        rvNotes.layoutManager = LinearLayoutManager(this);
        rvNotes.adapter = adapter;
        presenter.getAllNote();

    }

    override fun onDeletSuccess() {
    }

    override fun onDeleteAllSuccess() {
    }

    override fun onFetchData(result: ArrayList<Note>) {
        data.addAll(result);
        adapter.notifyDataSetChanged();
    }


    override fun onShowLoading() {
        loader.visibility = View.VISIBLE;
    }

    override fun onHideLoading() {
        loader.visibility = View.GONE;
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}