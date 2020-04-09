package com.ghalym.databasesexample.roomExample.Note.addNote

import android.content.Context
import com.ghalym.databasesexample.roomExample.Note.data.NoteDao
import com.ghalym.databasesexample.roomExample.Note.data.Note
import com.ghalym.databasesexample.roomExample.Note.data.NoteDatabase
import com.ghalym.databasesexample.roomExample.Note.data.NoteRepository

class AddNotePresenter(val iAddNoteView: IAddNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        val noteDao = NoteDatabase.getDatabase(context).noteDao();

        noteRepository = NoteRepository(noteDao);
    }

    fun addNote(note: Note) {
        iAddNoteView.onShowLoading()
         noteRepository.insertNoteToDb(note);
        iAddNoteView.onHideLoading()
        //if (result)
        iAddNoteView.onAddSuccess() //else iAddNoteView.onError(context.getString(R.string.insert_error))
    }


}