package com.ghalym.databasesexample.roomExample.Note.updateNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.realmExample.Note.data.NoteRepository
import com.ghalym.databasesexample.roomExample.Note.data.Note
import com.ghalym.databasesexample.roomExample.Note.data.NoteDatabase

class UpdateNotePresenter(val iUpdateNoteView: IUpdateNoteView, val context: Context) {

    val noteRepository: com.ghalym.databasesexample.roomExample.Note.data.NoteRepository;

    init {
        val noteDao = NoteDatabase.getDatabase(context).noteDao();

        noteRepository = com.ghalym.databasesexample.roomExample.Note.data.NoteRepository(noteDao);
    }


    fun updateNote(note: Note) {
        iUpdateNoteView.onShowLoading()
        noteRepository.updateNote(note);
         iUpdateNoteView.onUpdateSuccess() //else iUpdateNoteView.onError(context.getString(R.string.edit_note_error))
        iUpdateNoteView.onHideLoading()

    }


}