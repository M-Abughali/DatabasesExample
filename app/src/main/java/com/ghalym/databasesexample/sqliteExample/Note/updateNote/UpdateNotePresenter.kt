package com.ghalym.databasesexample.sqliteExample.Note.updateNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.sqliteExample.Note.data.NoteRepository
import com.ghalym.databasesexample.sqliteExample.Note.data.Note

class UpdateNotePresenter(val iUpdateNoteView: IUpdateNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, null);
    }


    fun updateNote(note: Note) {
        iUpdateNoteView.onShowLoading()
        val result = noteRepository.updateNote(note);
        if (result) iUpdateNoteView.onUpdateSuccess() else iUpdateNoteView.onError(context.getString(R.string.edit_note_error))
        iUpdateNoteView.onHideLoading()

    }


}