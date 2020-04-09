package com.ghalym.databasesexample.roomExample.Note.data

import android.content.Context
import androidx.room.*


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNoteToDb(note: Note)

    @Delete
    fun removeNoteFromDb(note: Note)

    @Query("select * from note_table")
    fun getAllNote(): List<Note>

    @Query("delete from note_table")
     fun deleteAllNotes()

    @Update()
    fun updateNote(vararg note: Note)


}