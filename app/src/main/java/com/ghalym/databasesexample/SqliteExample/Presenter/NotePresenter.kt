package com.ghalym.databasesexample.SqliteExample.Presenter

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.data.DbConnection
import com.ghalym.databasesexample.SqliteExample.data.Note
import com.ghalym.databasesexample.SqliteExample.ui.INoteView

class NotePresenter(val iNotePresenter: INotePresenter, val context: Context) {

    val dbConnection: DbConnection;

    init {
        dbConnection = DbConnection(context, "db", null, 1);
    }

    fun addNote(note: Note) {
        val result = dbConnection.insertNoteToDb(note);
        if (result) iNotePresenter.onAddSuccess() else iNotePresenter.onError(context.getString(R.string.insert_error))
    }


}