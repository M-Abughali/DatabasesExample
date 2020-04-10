package com.ghalym.databasesexample.roomExample.Note.displayNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.roomExample.Note.data.*

class DisplayNotePresenter(val iDisplayNoteView: IDisplayNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        val noteDao = AppDatabase(context).noteDao();

        noteRepository = NoteRepository(noteDao);
    }

    fun removeNoteFromDb(note: Note, position: Int) {
        iDisplayNoteView.onShowLoading()

        Thread {
            noteRepository.removeNoteFromDb(note);
            iDisplayNoteView.onDeletSuccess(position)
        }.start()
        // else iDisplayNoteView.onError(context.getString(R.string.delete_note_error))
        iDisplayNoteView.onHideLoading()

    }

    fun getAllNote() {
        iDisplayNoteView.onShowLoading()
        Thread {
            val result = noteRepository.getAllNote();
            iDisplayNoteView.onFetchData(result);
        }.start()

        iDisplayNoteView.onHideLoading()
    }

    fun deleteAllNotes() {
        iDisplayNoteView.onShowLoading()
        val result = noteRepository.deleteAllNotes();
        if (result) iDisplayNoteView.onDeleteAllSuccess() else iDisplayNoteView.onError(context.getString(R.string.delete_allNotes_error))
    }


}