package com.ghalym.databasesexample.realmExample.Note.displayNote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.realmExample.Note.data.Note
import com.ghalym.databasesexample.realmExample.Note.displayNote.NoteAdapter
import com.ghalym.databasesexample.realmExample.Note.updateNote.UpdateNoteActivity
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_display_notes.*
import kotlinx.android.synthetic.main.activity_display_notes.loader

class DisplayNotesActivity : AppCompatActivity(),
    IDisplayNoteView, OnShowOptionMenu {
    lateinit var presenter: DisplayNotePresenter;
    lateinit var adapter: NoteAdapter;
    var data = ArrayList<Note>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_notes)
        supportActionBar?.title = getString(R.string.lbl_displayNotesActivity_title_Realm)


        presenter = DisplayNotePresenter(this, this);
        adapter = NoteAdapter(data);
        adapter.onShowOptionMenu = this
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = adapter;


    }

    override fun onResume() {
        super.onResume()
        data.clear()
        presenter.getAllNote();
    }

    override fun onDeletSuccess(position: Int) {
        data.removeAt(position)
        adapter.notifyDataSetChanged();
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

    override fun showOption(view: View, position: Int) {

        val popUp = PopupMenu(this, view);
        popUp.inflate(R.menu.display_pop_up_menu)
        popUp.show();

        popUp.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.btnUpdate -> {
                    val intent = Intent(this, UpdateNoteActivity::class.java);
                    intent.putExtra("note", data[position])
                    startActivity(intent)
                }

                R.id.btnDelete -> presenter.removeNoteFromDb(data[position], position)

            }

            return@setOnMenuItemClickListener true;
        };
    }


}
