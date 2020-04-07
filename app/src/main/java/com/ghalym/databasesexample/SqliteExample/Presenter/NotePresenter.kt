package com.ghalym.databasesexample.SqliteExample.Presenter

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.data.NoteRepository
import com.ghalym.databasesexample.SqliteExample.Note.data.Note
import com.ghalym.databasesexample.SqliteExample.ui.INoteView

class NotePresenter(val iNoteView: INoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, "db", null, 1);
    }

    fun removeNoteFromDb(note: Note) {
        iNoteView.onShowLoading()
        val result = noteRepository.removeNoteFromDb(note);
        if (result) iNoteView.onDeletSuccess() else iNoteView.onError(context.getString(R.string.delete_note_error))
    }

    fun getAllNote(note: Note) {
        iNoteView.onShowLoading()
        val result = noteRepository.getAllNote();
        iNoteView.onFetchData(result);
    }

    fun deleteAllNotes() {
        iNoteView.onShowLoading()
        val result = noteRepository.deleteAllNotes();
        if (result) iNoteView.onDeleteAllSuccess() else iNoteView.onError(context.getString(R.string.delete_allNotes_error))
    }


}