package com.ghalym.databasesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGoToSqliteExample.setOnClickListener {
            var intent= Intent(this,com.ghalym.databasesexample.sqliteExample.Note.NoteActivity::class.java);
            startActivity(intent)
        }
        
        btnGoToRealmExample.setOnClickListener {
            var intent= Intent(this,com.ghalym.databasesexample.realmExample.Note.NoteActivity::class.java);
            startActivity(intent)
        }

        btnGoToRoomExample.setOnClickListener {
            var intent= Intent(this,com.ghalym.databasesexample.roomExample.Note.NoteActivity::class.java);
            startActivity(intent)
        }
    }
}
