package com.ghalym.databasesexample.SqliteExample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ghalym.databasesexample.R
import kotlinx.android.synthetic.main.activity_main.*

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToAddNote.setOnClickListener {

            val intent = Intent(this, AddNoteActivity::class.java);
            startActivity(intent)
        }


        btnGoToDisplayNotes.setOnClickListener {

            val intent = Intent(this, AddNoteActivity::class.java);
            startActivity(intent)
        }
    }
}
