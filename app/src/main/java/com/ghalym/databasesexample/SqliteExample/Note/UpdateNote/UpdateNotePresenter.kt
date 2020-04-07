package com.ghalym.databasesexample.SqliteExample.Note.addNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.data.NoteRepository
import com.ghalym.databasesexample.SqliteExample.Note.data.Note

class UpdateNotePresenter(val iUpdateNoteView: IUpdateNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, "db", null, 1);
    }


    fun updateNote(note: Note) {
        iUpdateNoteView.onShowLoading()
        val result = noteRepository.updateNote(note);
        iUpdateNoteView.onHideLoading()
        if (result) iUpdateNoteView.onUpdateSuccess() else iUpdateNoteView.onError(context.getString(R.string.edit_note_error))
    }


}