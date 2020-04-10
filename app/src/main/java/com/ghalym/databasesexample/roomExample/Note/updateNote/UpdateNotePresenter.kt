package com.ghalym.databasesexample.roomExample.Note.updateNote

import android.content.Context
import com.ghalym.databasesexample.R
import com.ghalym.databasesexample.realmExample.Note.data.NoteRepository
import com.ghalym.databasesexample.roomExample.Note.data.AppDatabase
import com.ghalym.databasesexample.roomExample.Note.data.Note

class UpdateNotePresenter(val iUpdateNoteView: IUpdateNoteView, val context: Context) {

    val noteRepository: com.ghalym.databasesexample.roomExample.Note.data.NoteRepository;

    init {
        val noteDao = AppDatabase(context).noteDao();

        noteRepository = com.ghalym.databasesexample.roomExample.Note.data.NoteRepository(noteDao);
    }


    fun updateNote(note: Note) {
        iUpdateNoteView.onShowLoading()
        Thread {
            noteRepository.updateNote(note);
        }.start()
         iUpdateNoteView.onUpdateSuccess() //else iUpdateNoteView.onError(context.getString(R.string.edit_note_error))
        iUpdateNoteView.onHideLoading()
        
    }


}