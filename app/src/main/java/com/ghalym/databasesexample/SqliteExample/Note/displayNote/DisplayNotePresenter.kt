package com.ghalym.databasesexample.SqliteExample.Note.displayNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.SqliteExample.Note.data.NoteRepository
import com.ghalym.databasesexample.SqliteExample.Note.data.Note

class DisplayNotePresenter(val iDisplayNoteView: IDisplayNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context, null);
    }

    fun removeNoteFromDb(note: Note,position:Int) {
        iDisplayNoteView.onShowLoading()
        val result = noteRepository.removeNoteFromDb(note);
        if (result) iDisplayNoteView.onDeletSuccess(position) else iDisplayNoteView.onError(context.getString(R.string.delete_note_error))
        iDisplayNoteView.onHideLoading()

    }

    fun getAllNote() {
        iDisplayNoteView.onShowLoading()
        val result = noteRepository.getAllNote();
        iDisplayNoteView.onFetchData(result);
        iDisplayNoteView.onHideLoading()
    }

    fun deleteAllNotes() {
        iDisplayNoteView.onShowLoading()
        val result = noteRepository.deleteAllNotes();
        if (result) iDisplayNoteView.onDeleteAllSuccess() else iDisplayNoteView.onError(context.getString(R.string.delete_allNotes_error))
    }


}