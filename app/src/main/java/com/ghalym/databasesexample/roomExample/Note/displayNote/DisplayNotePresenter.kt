package com.ghalym.databasesexample.roomExample.Note.displayNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.roomExample.Note.data.NoteRepository
import com.ghalym.databasesexample.roomExample.Note.data.Note

class DisplayNotePresenter(val iDisplayNoteView: IDisplayNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        noteRepository = NoteRepository(context);
    }

    fun removeNoteFromDb(note: Note,position:Int) {
        iDisplayNoteView.onShowLoading()
        val result = noteRepository.removeNoteFromDb(note);
         iDisplayNoteView.onDeletSuccess(position)// else iDisplayNoteView.onError(context.getString(R.string.delete_note_error))
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