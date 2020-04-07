package com.ghalym.databasesexample.SqliteExample.Note.addNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.data.NoteRepository
import com.ghalym.databasesexample.SqliteExample.Note.data.Note

class AddNotePresenter(val iAddNoteView: IAddNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, null);
    }

    fun addNote(note: Note) {
        iAddNoteView.onShowLoading()
        val result = noteRepository.insertNoteToDb(note);
        iAddNoteView.onHideLoading()
        if (result) iAddNoteView.onAddSuccess() else iAddNoteView.onError(context.getString(R.string.insert_error))
    }





}