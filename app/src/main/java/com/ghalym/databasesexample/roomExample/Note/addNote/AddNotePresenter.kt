package com.ghalym.databasesexample.roomExample.Note.addNote

import android.content.Context
import com.ghalym.databasesexample.roomExample.Note.data.*

class AddNotePresenter(val iAddNoteView: IAddNoteView, val context: Context) {

    val noteRepository: NoteRepository;

    init {
        val noteDao = AppDatabase(context).noteDao();

        noteRepository = NoteRepository(noteDao);
    }

    fun addNote(note: Note) {


        iAddNoteView.onShowLoading()
        Thread{

            noteRepository.insertNoteToDb(note);
        }.start()
        iAddNoteView.onHideLoading()
        //if (result)
        iAddNoteView.onAddSuccess() //else iAddNoteView.onError(context.getString(R.string.insert_error))
    }


}