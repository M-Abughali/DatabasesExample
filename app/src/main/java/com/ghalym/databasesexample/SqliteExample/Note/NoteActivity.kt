package com.ghalym.databasesexample.SqliteExample.Note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.addNote.UpdateNoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToAddNote.setOnClickListener {

            val intent = Intent(this, UpdateNoteActivity::class.java);
            startActivity(intent)
        }


        btnGoToDisplayNotes.setOnClickListener {

            val intent = Intent(this, UpdateNoteActivity::class.java);
            startActivity(intent)
        }
    }
}
