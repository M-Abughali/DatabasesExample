package com.ghalym.databasesexample.SqliteExample.Presenter

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.data.NoteRepository
import com.ghalym.databasesexample.SqliteExample.data.Note
import com.ghalym.databasesexample.SqliteExample.ui.IEditNoteView
import java.util.logging.Handler

class EditNotePresenter(val iEditNoteView: IEditNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, "db", null, 1);
    }

    fun addNote(note: Note) {
        iEditNoteView.onShowLoading()
        val result = noteRepository.insertNoteToDb(note);
        iEditNoteView.onHideLoading()
        if (result) iEditNoteView.onAddSuccess() else iEditNoteView.onError(context.getString(R.string.insert_error))
    }


    fun updateNote(note: Note) {
        iEditNoteView.onShowLoading()
        val result = noteRepository.updateNote(note);
        iEditNoteView.onHideLoading()
        if (result) iEditNoteView.onEditSuccess() else iEditNoteView.onError(context.getString(R.string.edit_note_error))
    }


}