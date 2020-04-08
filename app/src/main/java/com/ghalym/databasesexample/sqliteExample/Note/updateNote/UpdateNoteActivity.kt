package com.ghalym.databasesexample.sqliteExample.Note.updateNote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.sqliteExample.Note.data.Note
import kotlinx.android.synthetic.main.activity_add_note.editContent
import kotlinx.android.synthetic.main.activity_add_note.editTitle
import kotlinx.android.synthetic.main.activity_add_note.loader
import kotlinx.android.synthetic.main.activity_update_note.*

class UpdateNoteActivity : AppCompatActivity(),
    IUpdateNoteView {
    lateinit var presenter: UpdateNotePresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)
        presenter = UpdateNotePresenter(this, this);

        val note = intent.getSerializableExtra("note") as Note;
        editTitle.setText(note.title)
        editContent.setText(note.content)
        btnUpdate.setOnClickListener {
            var title = editTitle.text.toString();
            var content = editContent.text.toString();
            presenter.updateNote(Note(id = note.id, title = title, content = content));
        }
    }


    override fun onUpdateSuccess() {
        Toast.makeText(this, getString(R.string.update_success), Toast.LENGTH_SHORT).show()
        editTitle.text.clear();
        editContent.text.clear(); }

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
