package com.ghalym.databasesexample.SqliteExample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Presenter.EditNotePresenter
import com.ghalym.databasesexample.SqliteExample.data.Note
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity(), IEditNoteView {
    lateinit var presenter: EditNotePresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        presenter = EditNotePresenter(this, this);

        btnAdd.setOnClickListener {
            var title = editTitle.text.toString();
            var content = editContent.text.toString();
            presenter.addNote(Note(title = title, content = content));
        }
    }

    override fun onAddSuccess() {
        Toast.makeText(this, getString(R.string.insert_success), Toast.LENGTH_SHORT).show()
        editTitle.text.clear();
        editContent.text.clear();
    }

    override fun onEditSuccess() {
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
