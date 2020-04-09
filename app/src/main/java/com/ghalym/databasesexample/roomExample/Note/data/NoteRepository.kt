package com.ghalym.databasesexample.roomExample.Note.data

import androidx.room.*

class NoteRepository(val noteDao: NoteDao) {

    fun insertNoteToDb(note: Note) {
        noteDao.insertNoteToDb(note)
    }

    fun removeNoteFromDb(note: Note) {
        noteDao.removeNoteFromDb(note)
    }

    fun getAllNote(): List<Note> {
        return noteDao.getAllNote();
    }

    fun deleteAllNotes(): Boolean {
        noteDao.deleteAllNotes();
        return true;
    }

    fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }


}